package tim.mytrello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Users;
import tim.mytrello.form.EditProfileForm;
import tim.mytrello.form.RegistrationForm;
import tim.mytrello.repository.UserRepository;
import tim.mytrello.security.CustomUserDetails;
import tim.mytrello.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Controller
public class EditProfileController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile/edit")
    public String openEditProfile() {
        return "profile_edit";
    }

    @PostMapping("/profile/edit")
    public String editUser(EditProfileForm editProfileForm, Authentication authentication) throws IOException {
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getId();
        Optional<Users> usersOptional = userRepository.findById(userId);

        userService.editUser(editProfileForm, usersOptional.get().getId());
        return "redirect:/profile";
    }
}
