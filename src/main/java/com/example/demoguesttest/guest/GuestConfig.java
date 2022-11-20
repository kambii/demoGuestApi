package com.example.demoguesttest.guest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GuestConfig {

    @Bean
    CommandLineRunner commandLineRunner(GuestRepository guestRepository){
        return args -> {
            Guest kambii = new Guest(
                    "kambii"
            );

            Guest anton = new Guest(
                    "Anton"
            );

            Guest malin = new Guest(
                    "malin"
            );
            guestRepository.saveAll(
                    List.of(kambii,anton,malin)
            );
        };
    }
}
