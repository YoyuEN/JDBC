package com.yoyuen.jdbc.controller;

import com.yoyuen.jdbc.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试邮件发送
 * @author YoyuEN
 */
@RestController
@RequestMapping("/mail")
public class SendMailController {

    @Autowired
    private MailService mailService;


    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param text
     */
    @RequestMapping("/sendTextMail")
    public void sendTextMail(String to,String subject,String text){
        mailService.sendTextMailMessage(to,subject,text);
    }
}


