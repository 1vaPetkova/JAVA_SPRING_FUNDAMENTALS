package com.example.exam_prep_andreys.config;



import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new Pbkdf2PasswordEncoder();
//    }
}
