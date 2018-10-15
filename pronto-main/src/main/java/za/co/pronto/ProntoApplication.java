package za.co.pronto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"za.co.pronto.model"})
public class ProntoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProntoApplication.class);
    }
}
