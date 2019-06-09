package tim.mytrello.security;

import org.springframework.security.core.GrantedAuthority;
import tim.mytrello.entity.Users;

import java.util.Collection;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
public class CustomUserDetails extends Users implements org.springframework.security.core.userdetails.UserDetails {

    public CustomUserDetails(Users user) {
        super(user.getId(), user.getLogin(), user.getPassword(), user.getName(), user.getOwnEvents(), user.getOwnEvents());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
