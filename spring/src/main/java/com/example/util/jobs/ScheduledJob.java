package com.example.util.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.example.util.di.MyLogic;

public class ScheduledJob extends QuartzJobBean {


    private MyLogic myLogic;


    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
        myLogic.exec();
    }

    public void setMyLogic(MyLogic myLogic) {
        this.myLogic = myLogic;
    }
}
