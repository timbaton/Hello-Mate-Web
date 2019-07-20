package tim.mytrello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tim.mytrello.entity.Event;
import tim.mytrello.entity.Image;
import tim.mytrello.form.EventNewForm;
import tim.mytrello.repository.ImageRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

//    public List<Event> getAllEvents() throws UsernameNotFoundException {
//        List<Event> events = eventRepository.findAll();
//
//        return events;
//    }

    public Image getImageByName(String name) {
        return imageRepository.findImageByPath(name);
    }

    public Image getAvatar() {
        return getImageByName("ava.jpg");
    }

    public Image getImageById(Integer imageId) {
        return imageRepository.findImageById(imageId);
    }

    public void addImage(Image image) {

        imageRepository.save(image);
    }
}
