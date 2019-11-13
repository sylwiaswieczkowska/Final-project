package pl.sdacademy.finalproject.event;

import org.springframework.stereotype.Component;
import pl.sdacademy.finalproject.user.UserMapper;

@Component
public class EventMapper {

    private final UserMapper userMapper;

    public EventMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public EventModel fromEventDtoToEventModel(EventForm eventForm) {
        return EventModel.builder()
                .description(eventForm.getDescription())
                .title(eventForm.getTitle())
                .startEvent(eventForm.getStartEvent())
                .endEvent(eventForm.getEndEvent())
                .build();
    }

    public EventForm fromEventModelToEventDto(EventModel eventModel) {
        return EventForm.builder()
                .id(eventModel.getId())
                .description(eventModel.getDescription())
                .title(eventModel.getTitle())
                .startEvent(eventModel.getStartEvent())
                .endEvent(eventModel.getEndEvent())
                .registerForm(userMapper.fromUserModelToRegisterForm(eventModel.getUserModel()))
                .build();
    }
}
