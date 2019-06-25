package tim.mytrello.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Timestamp;
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
    private String location;

    private Timestamp date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonManagedReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Users owner;

    @ManyToMany(mappedBy = "events")
    @JsonBackReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<Users> participants;

    public Event(String title, String  description, String location, Timestamp date, List<Image> images, Users owner) {
//        TODO: remake it into map
        for (Image image: images) {
            image.setEvent(this);
        }

        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.images = images;
        this.owner = owner;
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
}
