package spring;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.example.util.jobs.HelloJob;

public class AppMain {
    public static void main(String args[]) throws SchedulerException {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Scheduler scheduler = context.getBean(SchedulerFactoryBean.class).getObject();
//
//        // define the job and tie it to our HelloJob class
//        JobDetail job = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("job1", "group1")
//                .build();
//
//        // Trigger the job to run now, and then repeat every 40 seconds
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1", "group1")
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                        .withIntervalInSeconds(1)
//                        .repeatForever())
//                .build();
//
//        // Tell quartz to schedule the job using our trigger
//        scheduler.scheduleJob(job, trigger);
    }

}
