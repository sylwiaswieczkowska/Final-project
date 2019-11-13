package pl.sdacademy.finalproject.event;

import org.springframework.stereotype.Service;
import pl.sdacademy.finalproject.exception.EmailExistsException;
import pl.sdacademy.finalproject.exception.EventExistException;
import pl.sdacademy.finalproject.user.UserMapper;
import pl.sdacademy.finalproject.user.model.UserModel;
import pl.sdacademy.finalproject.user.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper,
                        UserRepository userRepository, UserMapper userMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void saveEvent(EventForm eventForm) {
        UserModel userModel = userRepository.findByEmail(eventForm.getRegisterForm().getEmail())
                .orElseThrow(() -> new EmailExistsException("Email not found"));
        EventModel eventModel = eventMapper.fromEventDtoToEventModel(eventForm);
        eventModel.setUserModel(userModel);
        eventRepository.save(eventModel);

    }

    public List<EventForm> showEventList() {
        return eventRepository.findAll().stream()
                .map(eventMapper::fromEventModelToEventDto)
                .sorted(Comparator.comparing(EventForm::getStartEvent))
                .collect(Collectors.toList());
    }

    public List<EventForm> showEwentListIgnoreCase(String title) {
        if (title == null) {
            showEventList();
        }
        return eventRepository.findAllByTitleIgnoreCase(title).stream()
                .map(eventMapper::fromEventModelToEventDto)
                .collect(Collectors.toList());
    }

    public List<EventForm> showCurrentEvents() {
        return showEventList().stream()
                .filter(eventForm -> eventForm.getEndEvent().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    public List<EventForm> searchEvent(String title) {
        List<EventForm> eventForms = showEventList();
            if (eventForms.isEmpty()){
            throw new EventExistException("Event not exist");
        }
        return eventForms.stream()
                .filter(eventForm -> eventForm.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}

