package com.example.util.triggerSamples;

import java.util.Calendar;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.example.util.di.MyLogicImpl;
import com.example.util.jobs.DIJob;
import com.example.util.jobs.WithDataJob;


class DISample {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("key", new MyLogicImpl());

        JobDetail job = JobBuilder.newJob(DIJob.class).setJobData(jobDataMap).build();
        Trigger trigger = getOneTimeTrigger();
        scheduler.scheduleJob(job, trigger);
    }

    private static Trigger getOneTimeTrigger(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 1);
        return TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withRepeatCount(0))
                .startAt(cal.getTime())
                .build();
    }
}
