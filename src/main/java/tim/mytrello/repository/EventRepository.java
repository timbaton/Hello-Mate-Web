package tim.mytrello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tim.mytrello.entity.Event;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
public interface EventRepository extends JpaRepository<Event, Integer> {

    Event findEventById(Long eventId);
}
