package tim.mytrello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tim.mytrello.util.properties.FileStorageProperites;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperites.class,

})
public class HelloMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloMateApplication.class, args);
    }

}
