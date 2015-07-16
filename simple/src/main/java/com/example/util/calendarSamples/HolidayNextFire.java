package com.example.util.calendarSamples;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import com.example.util.Util;
import com.example.util.jobs.DIJob;


//to get calendar, we need adding trigger to schedule.
class HolidayNextFire {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail job = JobBuilder.newJob(DIJob.class).build();
        HolidayCalendar cal = new HolidayCalendar();
        cal.getExcludedDates().stream().forEach(v -> Util.print(v));
        scheduler.addCalendar("holidays", cal, false, false);

        Trigger trigger = getEveryOneSecondTrigger();
        scheduler.scheduleJob(job, trigger);


        Date d = trigger.getNextFireTime();
        Util.print(Util.toString(d));
        Date d2 = trigger.getFireTimeAfter(d);
        Util.print(Util.toString(d2));
        Date d3 = trigger.getFireTimeAfter(d2);
        Util.print(Util.toString(d3));
        Date d4 = trigger.getFireTimeAfter(d3);
        Util.print(Util.toString(d4));
        Date d5 = trigger.getFireTimeAfter(d4);
        Util.print(Util.toString(d5));
    }

    private static Trigger getEveryOneSecondTrigger(){
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(10, 30))
                .modifiedByCalendar("holidays")
                .startAt(Util.createDate("2015/10/07 00:00:00 Fri"))
                .build();
    }
}
