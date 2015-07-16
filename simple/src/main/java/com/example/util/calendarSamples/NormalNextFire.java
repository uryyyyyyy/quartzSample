package com.example.util.calendarSamples;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.example.util.Util;
import com.example.util.jobs.DIJob;


//to get calendar, we need adding trigger to schedule.
class NormalNextFire {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        Trigger trigger = getEveryOneSecondTrigger();
        JobDetail job = JobBuilder.newJob(DIJob.class).build();
        scheduler.scheduleJob(job, trigger);
        Date d = trigger.getNextFireTime();
        Util.print(Util.toString(d));
        Date d2 = trigger.getFireTimeAfter(d);
        Util.print(Util.toString(d2));
    }

    private static Trigger getEveryOneSecondTrigger(){
        return TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(20)
                        .repeatForever())
                .startAt(Util.createDate("2015/10/07 00:00:00 Fri"))
                .build();
    }
}
