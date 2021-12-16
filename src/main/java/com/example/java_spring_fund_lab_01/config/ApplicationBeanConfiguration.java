package com.example.java_spring_fund_lab_01.config;

import com.example.java_spring_fund_lab_01.util.FileUtil;
import com.example.java_spring_fund_lab_01.util.FileUtilImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public FileUtil fileUtil() {
        return new FileUtilImpl();
    }

//    @Bean
//    public Gson gson() {
//        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
//    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public XmlParser xmlParser() {
//        return new XmlParserImpl();
//    }
}
