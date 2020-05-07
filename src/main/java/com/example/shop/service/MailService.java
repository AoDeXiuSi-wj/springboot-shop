package com.example.shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.List;

@Service("mailService")
public class MailService {
    @Value("${spring.mail.username}")
    private  String from;
    @Autowired
    private JavaMailSender mailSender;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /***
     * 普通邮件
     * @param to 接收者
     * @param title 邮箱标题
     * @param content 邮箱内容
     * */
    public void sendSimpleMail(String to, String title,String content){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom(from);//发送者
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
        logger.info("邮件发送成功");
    }

    /**
     * 带附件的邮件
     * @param to
     * @param title
     * @param cotent
     * @param fileList
     */
    public void sendAttachmentsMail(String to, String title, String cotent, List<File> fileList){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(cotent);
            String fileName = null;
            for (File file:fileList) {
                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
                helper.addAttachment(fileName, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
        logger.info("邮件发送成功");
    }

}
