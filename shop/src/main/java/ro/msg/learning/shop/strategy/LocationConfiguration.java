package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LocationConfiguration {
    @Value("${strategy}")
    StrategyEnum strategy;

    @Bean
    public LocationStrategy locationStrategy() {

        return switch (strategy) {
            case SINGLE -> new SingleLocation();
            case ABUNDANT -> new MostAbundantLocation();
        };

    }
}
