package pl.sdacademy.finalproject.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventModel,Long> {
    List<EventModel>findAllByTitleIgnoreCase(String title);
}
