package com.example.fullcalendardemoapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public BookingMapper getMapper(){
        return BookingMapper.INSTANCE;
    }
}
