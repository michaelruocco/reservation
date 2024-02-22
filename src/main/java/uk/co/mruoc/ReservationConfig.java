package uk.co.mruoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationConfig {

    @Bean
    public ReservationRepository repository() {
        return new FakeDatabase();
    }
}
