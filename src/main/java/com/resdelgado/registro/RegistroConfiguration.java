package com.resdelgado.registro;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistroConfiguration {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
