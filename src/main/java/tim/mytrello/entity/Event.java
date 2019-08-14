package tim.mytrello.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @NotNull
    private Long date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Image> images;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonManagedReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Users owner;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(
            name = "event_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<Users> participants;

    public Event(String title, String description, Location location, Long date, List<Image> images, Users owner) {
//        TODO: remake it into map
        for (Image image : images) {
            image.setEvent(this);
        }

        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.images = images;
        this.owner = owner;
    }

    public String showTimeBefore() {
        Long curDate = new Timestamp(new Date().getTime()).getTime();

        String result = "";

        Long res = Math.abs(date - curDate) / 1000;

// get total days between two dates
        double days = Math.floor(res / 86400);
        if (days != 0) {
            result += days + " days ";
        }

// get hours
        double hours = Math.floor(res / 3600) % 24;
        if (hours != 0) {
            result += hours + " hours ";
        }

        double minutes = Math.floor(res / 60) % 60;
        result += minutes + " min";
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", images=" + images +
                '}';
    }

    public void addUser(Users user) {
        participants.add(user);
        user.addEvent(this);
    }

    public void deleteUser(Users user) {
        participants.remove(user);
        user.deleteEvent(this);
    }
}
