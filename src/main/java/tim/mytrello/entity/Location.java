package tim.mytrello.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double lat;
    private double lng;

    @OneToOne(mappedBy = "location")
    private Event event;

}
