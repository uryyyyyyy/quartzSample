package com.example;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.example.util.jobs.HelloJob;


class NowSample {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail job = JobBuilder.newJob(HelloJob.class).build();
        Trigger trigger = getNowTrigger();
        scheduler.scheduleJob(job, trigger);
    }

    public static Trigger getNowTrigger(){
        return TriggerBuilder.newTrigger().startNow()
                .build();
    }
}
