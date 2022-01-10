package com.example.exam_prep_coffee_shop.config;

import com.example.exam_prep_coffee_shop.util.ValidationUtil;
import com.example.exam_prep_coffee_shop.util.ValidationUtilImpl;
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
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new Pbkdf2PasswordEncoder();
//    }
}
