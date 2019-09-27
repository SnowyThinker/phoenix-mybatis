package org.snowman.phoenix;

import io.github.snowthinker.Id.SnowFlaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhoenixMyBatisApplication {

    @Bean
    public SnowFlaker snowFlaker() {
        return new SnowFlaker();
    }

    public static void main(String[] args) {
        SpringApplication.run(PhoenixMyBatisApplication.class, args);
    }
}
