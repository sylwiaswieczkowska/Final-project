package pl.sdacademy.finalproject.event;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sdacademy.finalproject.user.RegisterForm;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventForm {

    @NotNull
    @NotBlank
    private String title;
    private Long id;

    @Size(min = 20, message = "min 20 znaków")
    private String description;

    @Future(message = "wrong date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startEvent;

    @Future(message = "wrong date")
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endEvent;

    private RegisterForm registerForm;

}
