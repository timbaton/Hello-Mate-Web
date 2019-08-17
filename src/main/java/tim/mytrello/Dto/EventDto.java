package tim.mytrello.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Image;
import tim.mytrello.entity.Location;
import tim.mytrello.entity.Users;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by timurbadretdinov on Jul, 2019
 **/
@Data
@AllArgsConstructor
public class EventDto {

    private Long id;

    private String title;

    private String description;
    private LocationDto location;

    private String date;

    private List<ImageDto> images;

    private UserDto owner;

    private List<UserDto> participants;

//    private List<Event> ownEvents;
//
//    private List<Event> registeredEvents;


    public static EventDto from(Event event) {
        List<UserDto> participants = new LinkedList<>();
        List<ImageDto> images = new LinkedList<>();

        if (event.getParticipants() != null) {
            for (Users user : event.getParticipants()) {
                UserDto from = UserDto.from(user);
                participants.add(from);
            }
        }

        if (event.getImages() != null) {
            for (Image image : event.getImages()) {
                ImageDto from = ImageDto.from(image);
                images.add(from);
            }
        }

        UserDto from = UserDto.from(event.getOwner());

        return new EventDto(event.getId(), event.getTitle(), event.getDescription(), LocationDto.from(event.getLocation()), event.getDate().toString(), images, from, participants);
    }
}
