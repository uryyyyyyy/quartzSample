package com.example;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


class LamdbaJobSample {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail job = getLambdaJob();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();
        scheduler.scheduleJob(job, trigger);
    }

    //doesn't work
    private static JobDetail getLambdaJob(){
        return JobBuilder.newJob(((Job) jobExecutionContext -> System.out.println("lambda job")).getClass())
                .build();
    }

    //doesn't work
    private static JobDetail getAnonymousClassJob(){
        return JobBuilder.newJob((new Job() {
            @Override
            public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
                System.out.println("lambda job");
            }
        }).getClass())
                .build();
    }
}
