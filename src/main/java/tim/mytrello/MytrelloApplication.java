package tim.mytrello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tim.mytrello.util.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class MytrelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytrelloApplication.class, args);
    }

}
