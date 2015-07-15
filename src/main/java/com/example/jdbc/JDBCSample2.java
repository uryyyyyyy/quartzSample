package com.example.jdbc;

import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;


class JDBCSample2 {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.getTriggerGroupNames().stream().forEach(System.out::println);
        scheduler.getTriggerKeys(GroupMatcher.groupEquals("triggerGroup1")).stream().forEach(System.out::println);
        CronTrigger trigger = (CronTrigger)scheduler.getTrigger(new TriggerKey("cronTrigger1", "triggerGroup1"));
        System.out.println(trigger.getNextFireTime());
        System.out.println(trigger.getCronExpression());

        scheduler.start();
    }
}
