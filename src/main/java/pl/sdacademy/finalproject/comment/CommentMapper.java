package pl.sdacademy.finalproject.comment;

import org.springframework.stereotype.Component;
import pl.sdacademy.finalproject.event.EventMapper;
import pl.sdacademy.finalproject.user.UserMapper;

@Component
public class CommentMapper {

    private final UserMapper userMapper;
    private final EventMapper eventMapper;

    public CommentMapper(UserMapper userMapper, EventMapper eventMapper) {
        this.userMapper = userMapper;
        this.eventMapper = eventMapper;
    }

    public CommentModel fromCommentDtoToCommentModel(CommentDto commentDto){
       return CommentModel.builder()
               .description(commentDto.getDescription())
               .dateOfCreation(commentDto.getDateOfCreation())
               .eventModel(eventMapper.fromEventDtoToEventModel(commentDto.getEventForm()))
               .userModel(userMapper.fromRegisterFormToUserModel(commentDto.getRegisterForm()))
               .build();
    }

    public CommentDto fromCommentModelToCommentDto(CommentModel commentModel){
        return CommentDto.builder()
                .description(commentModel.getDescription())
                .dateOfCreation(commentModel.getDateOfCreation())
                .eventForm(eventMapper.fromEventModelToEventDto(commentModel.getEventModel()))
                .registerForm(userMapper.fromUserModelToRegisterForm(commentModel.getUserModel()))
                .build();
    }
}
