package tim.mytrello.restClient.entity;

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
public class RestEditProfileForm {

    private Integer id;
    private String name;
    private String surname;
    private String mail;
    private String phone;

    private MultipartFile avatar;
}
