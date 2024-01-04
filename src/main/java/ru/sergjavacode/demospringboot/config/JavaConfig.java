package ru.sergjavacode.demospringboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sergjavacode.demospringboot.SystemProfile;
import ru.sergjavacode.demospringboot.profile.DevProfile;
import ru.sergjavacode.demospringboot.profile.ProductionProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(value = "sergjavacode.profile.dev", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "sergjavacode.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
