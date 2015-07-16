package com.example;

import org.quartz.SchedulerException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
class HelloWorld {

    public static void main(String[] args) throws SchedulerException {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class)) {
            MainExecuter main = context.getBean(MainExecuter.class);
            main.execute();
        }
    }
}
