package pl.sdacademy.finalproject.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EventExistException extends RuntimeException {
    public EventExistException(String massage){
        super(massage);
    }
}
