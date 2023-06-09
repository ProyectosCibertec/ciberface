package pe.edu.cibertec;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.domain.entity.User;
import pe.edu.cibertec.infrastructure.out.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GenerateSampleData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final Faker faker;

    public GenerateSampleData(
            UserRepository userRepository,
            Faker faker) {
        this.userRepository = userRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    User user = new User();
                    user.setBiography("Hello! I'm a single user");
                    user.setUserName(faker.name().username());
                    user.setEmail(faker.internet().emailAddress());
                    user.setFirstName(faker.name().firstName());
                    user.setLastName(faker.name().lastName());
                    user.setPassword(faker.internet().password());
                    user.setPhotoUrl(faker.internet().avatar());
                    return user;
                }).collect(Collectors.toList());
        userRepository.saveAll(users);
    }
}
