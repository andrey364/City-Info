package by.resliv.tourist_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "by.resliv.tourist_bot")
@EntityScan(basePackages = "by.resliv.tourist_bot")
public class TouristBotApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(TouristBotApplication.class, args);
    }

}
