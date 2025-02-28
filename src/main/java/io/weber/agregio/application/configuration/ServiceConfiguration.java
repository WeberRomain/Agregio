package io.weber.agregio.application.configuration;

import io.weber.agregio.domain.interfaces.repositories.MarketRepository;
import io.weber.agregio.domain.interfaces.repositories.ParkRepository;
import io.weber.agregio.domain.interfaces.services.MarketService;
import io.weber.agregio.domain.interfaces.services.ParkService;
import io.weber.agregio.domain.services.MarketServiceImpl;
import io.weber.agregio.domain.services.ParkServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
    @Bean
    public ParkService parkService(ParkRepository parkRepository) {
        return new ParkServiceImpl(parkRepository);
    }

    @Bean
    public MarketService marketService(MarketRepository marketRepository) {
        return new MarketServiceImpl(marketRepository);
    }
}
