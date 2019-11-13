package pl.sdacademy.finalproject.event;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sdacademy.finalproject.exception.EventExistException;
import pl.sdacademy.finalproject.user.UserMapper;
import pl.sdacademy.finalproject.user.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event")
    public String showEventForm(Model model) {
        model.addAttribute("eventForm", new EventForm());
        return "eventForm";
    }

    @PostMapping("/event")
    public String handleEventForm(@ModelAttribute @Valid EventForm eventForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "eventForm";
        }
        eventService.saveEvent(eventForm);
        return "redirect:/";
    }
    @GetMapping("/")
    public String showEventList(Model model){
        List<EventForm> eventFormList = eventService.showCurrentEvents();
        if (eventFormList.isEmpty()){
            return "homePage";
        }
        model.addAttribute("eventFormList", eventFormList);
        return "homePage";
    }

    @GetMapping("/search")
    public String listEvents(@RequestParam(name = "title") String title, Model model) {
       try {
           List<EventForm> eventForm = eventService.searchEvent(title);

        model.addAttribute("eventForm",eventForm );
        model.addAttribute("title", title);
        return "homePage";}
       catch (EventExistException e){
           return "homePage";
       }
    }
}
