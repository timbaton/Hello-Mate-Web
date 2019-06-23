package tim.mytrello.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventNewForm {

    private String title;
    private String description;
    private String location;
    private String date;

    private MultipartFile[] images;
}
