package cn.chinatax.microweatherbasic.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author Tigger
 * @ClassName WeatherDataSyncJob
 * @Description //TODO
 * @Date
 * @Version 1.0
 **/

public class WeatherDataSyncJob extends QuartzJobBean {

    private static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.info("weather Data sync Job");
    }
}
