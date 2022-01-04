package com.example.java_spring_fund_pathfinder.config;

import com.example.java_spring_fund_pathfinder.util.ValidationUtil;
import com.example.java_spring_fund_pathfinder.util.ValidationUtilImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
