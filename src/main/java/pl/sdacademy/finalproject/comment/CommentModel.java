package pl.sdacademy.finalproject.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.sdacademy.finalproject.event.EventModel;
import pl.sdacademy.finalproject.user.model.UserModel;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Setter
@Getter
@Table(name = "comment")
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel userModel;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventModel eventModel;
    private LocalDateTime dateOfCreation;
}
