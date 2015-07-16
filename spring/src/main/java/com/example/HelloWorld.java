package com.example;

import org.quartz.SchedulerException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
class HelloWorld {

    public static void main(String[] args) throws SchedulerException {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class)) {
            SchedulerFactoryBean scheduler = context.getBean(SchedulerFactoryBean.class);
            scheduler.getObject().start();
            MainExecutor main = context.getBean(MainExecutor.class);
            main.execute();
        }
    }
}
