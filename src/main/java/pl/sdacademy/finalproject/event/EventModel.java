package pl.sdacademy.finalproject.event;

import lombok.*;
import pl.sdacademy.finalproject.user.model.UserModel;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    @Column(name = "start")
    private LocalDateTime startEvent;

    @Column(name = "end")
    private LocalDateTime endEvent;
}
