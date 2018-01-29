package ru.mccarl.client.api;

/**
 * Created by vrudometkin on 24/11/2017.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
        "ru.mccarl.order.api.configuration",
        "ru.mccarl.order.api.entity",
        "ru.mccarl.order.api.web",
        "ru.mccarl.order.api.repository"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
