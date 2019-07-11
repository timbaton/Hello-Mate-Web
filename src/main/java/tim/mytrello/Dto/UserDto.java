package tim.mytrello.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Token;
import tim.mytrello.entity.Users;

import java.util.List;

/**
 * Created by timurbadretdinov on Jul, 2019
 **/
@Data
@AllArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String surname;
    private String mail;
    private String phone;

//    private List<Event> ownEvents;
//
//    private List<Event> registeredEvents;


    public static UserDto from(Users user) {
        return new UserDto(user.getId(), user.getName(), user.getSurname(), user.getMail(), user.getPhone());
    }
}