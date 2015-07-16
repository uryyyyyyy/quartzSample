package com.example.util.triggerSamples;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.example.util.jobs.HelloJob;


class EverySecondSample {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail job = JobBuilder.newJob(HelloJob.class).build();
        Trigger trigger = getEveryOneSecondTrigger();
        scheduler.scheduleJob(job, trigger);
    }

    private static Trigger getEveryOneSecondTrigger(){
        return TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();
    }
}
