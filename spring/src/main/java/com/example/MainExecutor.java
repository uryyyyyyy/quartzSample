package com.example;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import com.example.util.jobs.HelloJob;

@Component
public class MainExecutor {

    public void execute() throws SchedulerException {
//        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        scheduler.start();
//        JobDetail job = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("job1", "group1")
//                .build();
//
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1", "group1")
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                        .withIntervalInSeconds(1)
//                        .repeatForever())
//                .build();
//
//        scheduler.scheduleJob(job, trigger);
    }
}
