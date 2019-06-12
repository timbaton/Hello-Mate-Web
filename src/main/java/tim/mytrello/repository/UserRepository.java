package tim.mytrello.repository;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import tim.mytrello.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findUserByLogin(String login);

}
