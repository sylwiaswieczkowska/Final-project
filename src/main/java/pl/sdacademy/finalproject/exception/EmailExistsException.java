package pl.sdacademy.finalproject.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmailExistsException extends RuntimeException {
    public EmailExistsException(String message) {
        super(message);
    }
}
