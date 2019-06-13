package tim.mytrello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tim.mytrello.entity.Event;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.repository.EventRepository;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;

import java.util.List;
import java.util.Optional;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() throws UsernameNotFoundException {
        List<Event> events = eventRepository.findAll();

        return events;
    }
}
