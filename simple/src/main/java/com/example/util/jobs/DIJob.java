package com.example.util.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.example.util.di.MyLogic;

public class DIJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("DIJob");
        JobDataMap jobDataMap = context.getMergedJobDataMap();

        MyLogic helloJob = (MyLogic)jobDataMap.get("key");
        helloJob.exec();
    }
}
