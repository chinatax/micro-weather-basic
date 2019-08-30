package cn.chinatax.microweatherbasic.config;

import cn.chinatax.microweatherbasic.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Tigger
 * @ClassName QuartzConfiguration
 * @Description //TODO
 * @Date
 * @Version 1.0
 **/
@Configuration
public class QuartzConfiguration {
    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably()
                .build();
    }
    //Trigger
    @Bean
    public Trigger weatherDatasyncTrigger(){

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();

    }
}
