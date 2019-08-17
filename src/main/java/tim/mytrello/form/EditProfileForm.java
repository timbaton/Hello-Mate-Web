package tim.mytrello.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditProfileForm {

    private String name;
    private String surname;
    private String mail;
    private String phone;

    private MultipartFile avatar;
}
