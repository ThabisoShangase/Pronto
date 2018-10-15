package za.co.pronto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import za.co.pronto.model.UserInfo;
import za.co.pronto.repositories.UserRepository;

import java.util.Date;

@SpringBootApplication
@EntityScan(basePackages = {"za.co.pronto.model"})
public class ProntoApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProntoApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
