package pe.edu.cibertec;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class FakerConfig {
    @Bean
    Faker faker() {
        return new Faker(new Locale("es"));
    }
}
