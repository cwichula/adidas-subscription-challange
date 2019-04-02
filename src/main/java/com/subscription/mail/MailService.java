package com.subscription.mail;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@AllArgsConstructor
class MailService {

    private JavaMailSender javaMailSender;
    private MailProperties mailProperties;

    void sendConfirmation(final String to) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(mailProperties.getMailMessageTopic());
        message.setText(mailProperties.getMailMessageDescription());
        javaMailSender.send(message);

    }


}
