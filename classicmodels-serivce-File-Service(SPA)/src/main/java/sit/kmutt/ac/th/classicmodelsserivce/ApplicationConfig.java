package sit.kmutt.ac.th.classicmodelsserivce;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sit.kmutt.ac.th.classicmodelsserivce.properties.FileStorageProperties;
import sit.kmutt.ac.th.classicmodelsserivce.services.utils.ListMapper;

import java.util.List;
@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})


@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ListMapper listMapper(){
        return ListMapper.getInstance();
    }
}
