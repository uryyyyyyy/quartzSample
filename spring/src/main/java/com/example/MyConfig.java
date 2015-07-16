package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.util.di.MyLogic;
import com.example.util.di.MyLogicImpl;

@Configuration
@ComponentScan("com.example")
public class MyConfig {

    @Bean
    public MyLogic myLogic() {
        return new MyLogicImpl();
    }
}
