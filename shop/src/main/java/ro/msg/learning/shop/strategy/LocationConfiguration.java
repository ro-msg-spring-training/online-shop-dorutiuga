package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.exceptions.OrderCreationException;

import static ro.msg.learning.shop.strategy.StrategyEnum.SINGLE;

@Configuration
public class LocationConfiguration {
    @Value("${strategy}")
    StrategyEnum strategy;

    @Bean
    public LocationStrategy locationStrategy() {

        switch (strategy) {
            case SINGLE:
                return new SingleLocation();
            case ABUNDANT:
                return new MostAbundantLocation();
            default:
                throw new OrderCreationException("Something went wrong");
        }

    }
}
