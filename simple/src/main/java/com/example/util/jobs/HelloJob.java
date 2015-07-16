package com.example.util.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("HelloJob");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException ignored) {
        }
    }
}
