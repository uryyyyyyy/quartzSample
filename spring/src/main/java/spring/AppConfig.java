package spring;

import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import spring.quartz.ScheduledJob;

@Configuration
@ComponentScan("com.websystique.spring")
public class AppConfig {

    @Bean
    public SchedulerFactoryBean quartzScheduler() {
        SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();
        quartzScheduler.setTriggers(simpleTriggerFactoryBean2().getObject());
        return quartzScheduler;
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetMethod("printMessage");
        bean.setTargetObject(new MyBean());
        return bean;
    }

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(ScheduledJob.class);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("myBean", new MyBean());
        bean.setJobDataMap(jobDataMap);
        return bean;
    }

    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        bean.setStartDelay(1000);
        bean.setRepeatInterval(2000);
        return bean;
    }

    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean2() {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        bean.setStartDelay(2000);
        bean.setRepeatInterval(3000);
        return bean;
    }

}
