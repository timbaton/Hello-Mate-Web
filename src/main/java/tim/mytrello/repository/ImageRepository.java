package tim.mytrello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tim.mytrello.entity.Image;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
public interface ImageRepository extends JpaRepository<Image, Integer> {

    public Image findImageById(Integer id);
}
