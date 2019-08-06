package tim.mytrello.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Image;
import tim.mytrello.entity.Users;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by timurbadretdinov on Jul, 2019
 **/
@Data
@AllArgsConstructor
public class ImageDto {

    private Long id;

    private String path;
    private Timestamp date;

    public static ImageDto from(Image image) {
        return new ImageDto(image.getId(), image.getPath(), image.getDate());
    }
}
