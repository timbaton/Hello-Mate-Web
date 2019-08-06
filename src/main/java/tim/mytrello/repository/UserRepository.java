package tim.mytrello.repository;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tim.mytrello.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findUserByLogin(String login);

    @Query(nativeQuery = true, value = "select * from users")
    List<Users> findAllById(int id);

    Optional<Users> findUserById(int id);
}
