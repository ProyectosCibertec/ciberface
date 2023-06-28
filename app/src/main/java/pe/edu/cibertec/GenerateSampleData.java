package pe.edu.cibertec;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.domain.entity.Post;
import pe.edu.cibertec.domain.entity.User;
import pe.edu.cibertec.infrastructure.out.PostRepository;
import pe.edu.cibertec.infrastructure.out.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class GenerateSampleData implements CommandLineRunner {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Faker faker;

    public GenerateSampleData(
            PostRepository postRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            Faker faker) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
                    user.setPassword(passwordEncoder.encode("12345"));
                    user.setPhotoUrl("https://cdn-icons-png.flaticon.com/512/149/149071.png");
                    return user;
                }).collect(Collectors.toList());
        userRepository.saveAll(users);

        List<Post> posts = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    User user = users.get(faker.number().numberBetween(0, 5));
                    Post post = new Post();
                    post.setPostContent(faker.friends().quote());
                    post.setCreationDate(new Date());
                    post.setUserId(user);
                    return post;
                }).collect(Collectors.toList());
        postRepository.saveAll(posts);
    }
}
