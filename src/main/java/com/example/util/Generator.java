package com.example.util;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import com.example.util.jobs.Hello2Job;
import com.example.util.jobs.HelloJob;


public class Generator {

    public static JobDetail getHelloJob(){
        return JobBuilder.newJob(HelloJob.class)
                .build();
    }

    public static JobDetail getHello2Job(){
        return JobBuilder.newJob(Hello2Job.class)
                .build();
    }

    public static JobDetail getNamedHelloJob(){
        return JobBuilder.newJob(HelloJob.class)
                .withIdentity("hello")
                .build();
    }

    //doesn't work
    public static JobDetail getLambdaJob(){
        return JobBuilder.newJob(((Job) jobExecutionContext -> System.out.println("lambda job")).getClass())
                .build();
    }

    //doesn't work
    public static JobDetail getAnonymousClassJob(){
        return JobBuilder.newJob((new Job() {
            @Override
            public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
                System.out.println("lambda job");
            }
        }).getClass())
                .build();
    }

    public static Trigger getEveryOneSecondTrigger(){
        return TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();
    }

    public static Trigger getNowTrigger(){
        return TriggerBuilder.newTrigger().startNow()
                .build();
    }
}
