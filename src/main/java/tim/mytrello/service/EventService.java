package tim.mytrello.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Image;
import tim.mytrello.entity.Location;
import tim.mytrello.entity.Users;
import tim.mytrello.form.EventNewForm;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.repository.EventRepository;
import tim.mytrello.repository.ImageRepository;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public List<Event> getAllEvents() throws UsernameNotFoundException {
        List<Event> events = eventRepository.findAll();

        return events;
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findEventById(eventId);
    }

    public void addEvent(EventNewForm eventNewForm, Users owner) throws IOException {
        List<Image> images = fileStorageService.storeFiles(eventNewForm.getImages());
        Timestamp curTime = new Timestamp(new Date().getTime());

        //Images
        for (Image fileName : images) {
            Image.builder()
                    .path(fileName.getPath())
                    .fileDownloadUri(fileName.getFileDownloadUri())
                    .date(curTime)
                    .build();
        }

        //Date
        String dateString = eventNewForm.getDate();
        Date date = null;
        SimpleDateFormat dateFromString = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        dateFromString.setLenient(false);
        try {
            date = dateFromString.parse(dateString);
            System.out.println(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assert date != null;
        Timestamp dateTimeStamp = new Timestamp(date.getTime());

        //location
        String locationSpring = eventNewForm.getLocation();
        String[] locationSplit = locationSpring.split(" ");
        Location location = Location.builder()
                .lat(Double.valueOf(locationSplit[0]))
                .lng(Double.valueOf(locationSplit[1]))
                .build();

        Event event = new Event(eventNewForm.getTitle(), eventNewForm.getDescription(), location, dateTimeStamp, images, owner);

        eventRepository.save(event);
    }

    @Transactional
    public void deleteEvent(Long event_id) {
        Event event = eventRepository.findEventById(event_id);

        eventRepository.delete(event);
    }

    public void deleteParticipants(Long event_id) {
        Event event = eventRepository.findEventById(event_id);

        event.setParticipants(new LinkedList<>());
        eventRepository.save(event);
    }

    public void addParticipant(Event event, int userId) {
        Optional<Users> usersOptional = userRepository.findById(userId);
        Users user = null;
        if (usersOptional.isPresent()) {
            user = usersOptional.get();
        }
        event.addUser(user);
        eventRepository.save(event);
    }

    public void deleteOneParticipant(Integer userId, Event event) {
        Optional<Users> usersOptional = userRepository.findById(userId);
        Users user = null;
        if (usersOptional.isPresent()) {
            user = usersOptional.get();
        }
        event.deleteUser(user);
        eventRepository.save(event);
    }
}
