package com.example;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Trigger;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.example.util.di.MyLogic;
import com.example.util.di.MyLogicImpl;
import com.example.util.jobs.HelloJob;

@Configuration
@ComponentScan("com.example")
public class MyConfig {

    @Bean
    public MyLogic myLogic() {
        return new MyLogicImpl();
    }

    @Bean
    public SchedulerFactoryBean quartzScheduler() {
        try {
            SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();

            PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
            propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
            Properties properties = propertiesFactoryBean.getObject();
            quartzScheduler.setQuartzProperties(properties);

            AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
            quartzScheduler.setJobFactory(jobFactory);

            Trigger[] triggers = { procesoMQTrigger().getObject() };
            quartzScheduler.setTriggers(triggers);

            return quartzScheduler;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Bean
    public JobDetailFactoryBean procesoMQJob() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(HelloJob.class);
        jobDetailFactory.setGroup("spring3-quartz");
        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean procesoMQTrigger() {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(procesoMQJob().getObject());
        cronTriggerFactoryBean.setCronExpression("* * * * * ?");
        cronTriggerFactoryBean.setGroup("spring3-quartz");
        return cronTriggerFactoryBean;
    }
}
