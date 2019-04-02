package com.subscription.mail;

import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSender;

public class MailServiceTest {

    @Test
    public void sendSimpleMessage() {
        MailProperties mailProperties = new MailProperties(
              null,null,null,null,null,
                null,null,null, null,
                null
        );
        MailConfig mailConfig = new MailConfig();
        JavaMailSender javaMailSender = mailConfig.javaMailSender(mailProperties);
        MailService mailService = mailConfig.mailService(javaMailSender, mailProperties);

        mailService.sendConfirmation("tadeusz.cwichula@gmail.com");
    }
}