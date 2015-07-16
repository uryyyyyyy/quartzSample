package com.example.util.jobs;

import java.util.Arrays;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class WithDataJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getMergedJobDataMap();

        System.out.println(Arrays.toString(jobDataMap.getKeys()));
        System.out.println(jobDataMap.getString("key1"));
        System.out.println(jobDataMap.getLongValue("key2"));

        HelloJob helloJob = (HelloJob)jobDataMap.get("key3");
        helloJob.execute(null);
    }
}
