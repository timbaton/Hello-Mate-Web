package tim.mytrello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tim.mytrello.entity.Event;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findEventById(Long eventId);

    Long deleteById(Long eventId);

}
