package com.subscription.mail;

import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSender;

public class MailServiceTest {

    @Test
    public void sendSimpleMessage() {
        MailConfig mailConfig = new MailConfig();
        JavaMailSender javaMailSender = mailConfig.javaMailSender();
        MailService mailService = mailConfig.mailService(javaMailSender);

        mailService.sendConfirmation("tadeusz.cwichula@gmail.com", "subscription test", "<H1>Template</H1>");
    }
}