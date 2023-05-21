package com.vladrip.ifchat.service;

import com.vladrip.ifchat.entity.Device;
import com.vladrip.ifchat.exception.EntityNotFoundException;
import com.vladrip.ifchat.repository.DeviceRepository;
import com.vladrip.ifchat.repository.MessageRepository;
import com.vladrip.ifchat.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final PersonRepository personRepository;

    public void create(String personUid, String deviceToken) {
        Device device = new Device();
        device.setPerson(personRepository.findById(personUid)
                .orElseThrow(()->EntityNotFoundException.of("Person", personUid)));
        device.setDeviceToken(deviceToken);
        device.setTokenTimestamp(LocalDateTime.now());
        deviceRepository.save(device);
    }

    public void delete(String token) {
        deviceRepository.deleteByDeviceToken(token);
    }
}
