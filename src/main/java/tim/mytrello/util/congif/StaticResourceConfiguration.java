package tim.mytrello.util.congif;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by timurbadretdinov on Jun, 2019
 **/
@Configuration
public class StaticResourceConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/event/uploads")) {
            registry.addResourceHandler("/event/uploads")
                    .addResourceLocations("classpath:/uploads/");

        } else {
            System.out.println("hello");
        }


        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/")
                .resourceChain(false);
    }
}
