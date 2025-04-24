package com.yoyuen.jdbc.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
// 定制的任务（每天8点或者或用户注册时发送邮件）
public class MyJob implements Job {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String email = jobExecutionContext.getJobDetail().getJobDataMap().getString("email");
        System.out.println("发送电子邮件--------" + email);
    }
}
