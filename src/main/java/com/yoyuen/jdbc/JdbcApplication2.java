package com.yoyuen.jdbc;

import com.yoyuen.jdbc.quartz.MyJob;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JdbcApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication2.class, args);

    }

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(MyJob.class)
                .withIdentity("sendMailJob")
                .usingJobData("email", "15839393171@163.com")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {
        return TriggerBuilder.newTrigger()
                .forJob("sendMailJob")
                .withIdentity("mailTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 8 * * ?"))
//                .startNow()
                .build();
    }

}
