package tim.mytrello.repository;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import tim.mytrello.entity.Users;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findUserByLogin(String login);

    @Query(nativeQuery = true, value = "select * from users")
    List<Users> findAllById(int id);

    Optional<Users> findUserById(int id);

//    @Async
//    CompletableFuture<Users> findById(int id);
}
