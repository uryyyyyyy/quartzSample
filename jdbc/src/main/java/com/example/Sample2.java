package com.example;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.example.util.Generator;


class Sample2 {
    public static void main(String[] args) throws SchedulerException {
        System.out.println("Hello World");
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail job = Generator.getHello2Job();
        Trigger trigger = Generator.getNowTrigger();
        scheduler.scheduleJob(job, trigger);
    }
}
