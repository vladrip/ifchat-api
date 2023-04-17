package com.vladrip.ifchat.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Entity not found")
public class EntityNotFoundException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger("application");
    private static final String DEFAULT_MSG = "Entity not found";

    public EntityNotFoundException() {
        super(DEFAULT_MSG);
    }

    public EntityNotFoundException(String message) {
        super(message);
        log.error("EntityNotFoundException: " + message);
    }

    public static EntityNotFoundException of(String entityName, Long entityId) {
        return new EntityNotFoundException(String.format("%s: %s id:%d", DEFAULT_MSG, entityName, entityId));
    }

    public static EntityNotFoundException of(String format, Object... args) {
        return new EntityNotFoundException(String.format(format, args));
    }
}
