package com.example.util.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.util.di.MyLogic;

@Component
public class HelloJob implements Job {

    @Autowired
    private MyLogic myLogic;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try{
            myLogic.exec();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
