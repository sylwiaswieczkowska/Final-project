package pl.sdacademy.finalproject.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.sdacademy.finalproject.event.EventForm;
import pl.sdacademy.finalproject.user.RegisterForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class CommentDto {

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(max = 500, message = "max 500 znaków")
    private String description;
    private LocalDateTime dateOfCreation;
    private RegisterForm registerForm;
    private EventForm eventForm;
}