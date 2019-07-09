package tim.mytrello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tim.mytrello.entity.Token;

/**
 * Created by timurbadretdinov on May, 2019
 **/
public interface TokenRepository extends JpaRepository<Token, Long> {
}
