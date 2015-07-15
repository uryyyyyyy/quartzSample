package com.example;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.example.util.Generator;


class Sample1 {
    public static void main(String[] args) throws SchedulerException {
        System.out.println("Hello World");
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail job = Generator.getHelloJob();
        Trigger trigger = Generator.getEveryOneSecondTrigger();
        scheduler.scheduleJob(job, trigger);
    }
}
