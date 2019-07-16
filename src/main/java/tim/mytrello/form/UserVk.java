package tim.mytrello.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVk {

    private String first_name;
    private String last_name;
    private String screen_name;
    private String mobile_phone;
//    private String photo_200;

}
