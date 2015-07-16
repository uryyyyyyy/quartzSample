package spring.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import spring.MyBean;

public class ScheduledJob extends QuartzJobBean {

    private MyBean myBean;

    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
        System.out.println("sasasasa");
        arg0.get
        myBean.printMessage();
    }

    public void setAnotherBean(MyBean myBean) {
        this.myBean = myBean;
    }
}
