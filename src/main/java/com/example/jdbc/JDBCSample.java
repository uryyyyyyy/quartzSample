package com.example.jdbc;

import java.util.TimeZone;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.example.util.jobs.WriteTextJob;


class JDBCSample {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = JobBuilder.newJob(WriteTextJob.class)
                .withIdentity("textWriteJob", "jobGroup1")
                .storeDurably()
                .build();

        CronTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("cronTrigger2", "triggerGroup1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("*/5 * * * * ?")
                                .inTimeZone(TimeZone.getTimeZone("Asia/Tokyo"))).startNow().build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
}
