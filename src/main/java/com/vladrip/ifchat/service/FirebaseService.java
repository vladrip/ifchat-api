package com.vladrip.ifchat.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.Notification;
import com.google.gson.Gson;
import com.vladrip.ifchat.dto.PersonDto;
import com.vladrip.ifchat.entity.Device;
import com.vladrip.ifchat.entity.Message;
import com.vladrip.ifchat.mapping.Mapper;
import com.vladrip.ifchat.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FirebaseService {
    private static final Logger log = LoggerFactory.getLogger(FirebaseService.class);
    private final FirebaseMessaging firebaseMessaging;
    private final FirebaseAuth firebaseAuth;
    private final ChatService chatService;
    private final DeviceRepository deviceRepository;
    private final Mapper mapper;
    private final Gson gson;

    public void sendFirebaseMessage(Message message) {
        try {
            String messageJson = gson.toJson(mapper.toMessageDto(message));
            String chatTypeJson = message.getChat().getType().name();
            String notificationBody = message.getContent().replaceAll("\n", " ").trim();
            switch (message.getChat().getType()) {
                case PRIVATE -> {
                    PersonDto otherPerson = chatService
                            .getChat(message.getChat().getId(), message.getSender().getUid()).getOtherPerson();
                    String otherPersonUid = otherPerson.getUid();
                    MulticastMessage firebaseMessage = MulticastMessage.builder()
                            .addAllTokens(deviceRepository.getAllByPersonUid(otherPersonUid)
                                    .stream().map(Device::getDeviceToken).collect(Collectors.toList()))
                            .putData("message", messageJson)
                            .putData("chatType", chatTypeJson)
                            .setNotification(Notification.builder()
                                    .setTitle(otherPerson.getFirstName().concat(" ").concat(otherPerson.getLastName()))
                                    .setBody(notificationBody)
                                    .build()
                            )
                            .build();
                    firebaseMessaging.sendMulticast(firebaseMessage);
                    //TODO detect and delete inactive tokens
                }

                case GROUP -> {
                    com.google.firebase.messaging.Message firebaseMessage = com.google.firebase.messaging.Message.builder()
                            .setTopic("g".concat(message.getChat().getId().toString()))
                            .putData("message", messageJson)
                            .putData("chatType", chatTypeJson)
                            .setNotification(Notification.builder()
                                    .setTitle(message.getChat().getName())
                                    .setBody(notificationBody)
                                    .build()
                            )
                            .build();
                    firebaseMessaging.send(firebaseMessage);
                }
            }
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public String uidFromToken(String authToken) {
        if (authToken.contains("Bearer "))
            authToken = authToken.replace("Bearer ", "");
        try {
            return firebaseAuth.verifyIdToken(authToken).getUid();
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }
}
