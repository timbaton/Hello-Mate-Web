package tim.mytrello.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Image;
import tim.mytrello.entity.Location;
import tim.mytrello.entity.Users;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by timurbadretdinov on Jul, 2019
 **/
@Data
@AllArgsConstructor
public class LocationDto {
    private Long id;

    private double lat;
    private double lng;


    public static LocationDto from(Location location) {
        List<UserDto> participants = null;

        return new LocationDto(location.getId(), location.getLat(), location.getLng());
    }
}
