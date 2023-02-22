package com.publisher;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.publisher.module"})
//@ComponentScan(basePackages = {"com.publisher.module"})
//@EntityScan(basePackages = {"com.publisher.module"})
public class PublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublisherApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
