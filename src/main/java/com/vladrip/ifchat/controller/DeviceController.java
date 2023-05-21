package com.vladrip.ifchat.controller;

import com.vladrip.ifchat.service.DeviceService;
import com.vladrip.ifchat.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {
    private final DeviceService deviceService;
    private final FirebaseService firebaseService;

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public void create(@RequestHeader(name = "Authorization") String authToken,
                       @RequestBody String deviceToken) {
        deviceService.create(firebaseService.uidFromToken(authToken), deviceToken);
    }

    @DeleteMapping("/{deviceToken}")
    public void delete(@PathVariable String deviceToken) {
        deviceService.delete(deviceToken);
    }
}
