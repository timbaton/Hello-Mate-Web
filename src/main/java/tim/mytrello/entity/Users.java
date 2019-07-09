package tim.mytrello.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Entity
@Builder
@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String password;

    private String name;
    private String surname;
    private String mail;
    private String phone;

    @OneToMany(mappedBy = "owner")
    @JsonBackReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<Event> ownEvents;

    @ManyToMany(mappedBy = "participants", fetch = FetchType.LAZY)
    @JsonBackReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<Event> events;


    @OneToMany(mappedBy = "responsibleUser")
    List<Token> tokens;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void deleteEvent(Event event) {
        List<Event> newEventList = new ArrayList<>();

        for (Event registeredEvent : events) {
            if (!registeredEvent.getId().equals(event.getId())) {
                newEventList.add(registeredEvent);
            }
        }
        events = newEventList;
    }
}
