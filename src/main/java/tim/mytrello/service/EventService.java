package tim.mytrello.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Image;
import tim.mytrello.entity.Users;
import tim.mytrello.form.EventNewForm;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.repository.EventRepository;
import tim.mytrello.repository.ImageRepository;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ImageService imageService;

    @Autowired
    private FileStorageService fileStorageService;

    public List<Event> getAllEvents() throws UsernameNotFoundException {
        List<Event> events = eventRepository.findAll();

        return events;
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findEventById(eventId);
    }

    public void addEvent(EventNewForm eventNewForm, Users owner) {
        List<String> files = fileStorageService.storeFiles(eventNewForm.getImages());
        List<Image> images = new LinkedList<>();
        Timestamp curTime = new Timestamp(new Date().getTime());

        for (String fileName : files) {
            Image image = Image.builder()
                    .path(fileName)
                    .date(curTime)
                    .build();

            images.add(image);
        }

        Event event = new Event(eventNewForm.getTitle(), eventNewForm.getDescription(), eventNewForm.getLocation(), curTime, images, owner);

        eventRepository.save(event);
    }
}
