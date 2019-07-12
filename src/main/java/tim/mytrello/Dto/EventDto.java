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
public class EventDto {

    private String title;

    private String description;
    private LocationDto location;

    private Timestamp date;

    private List<Image> images;

    private UserDto owner;

    private List<UserDto> participants;

//    private List<Event> ownEvents;
//
//    private List<Event> registeredEvents;


    public static EventDto from(Event event) {
        List<UserDto> participants = null;

        if (event.getParticipants() != null) {
            for (Users user : event.getParticipants()) {
                participants.add(UserDto.from(user));
            }
        }
        UserDto from = UserDto.from(event.getOwner());

        return new EventDto(event.getTitle(), event.getDescription(), LocationDto.from(event.getLocation()), event.getDate(), event.getImages(), from, participants);
    }
}
