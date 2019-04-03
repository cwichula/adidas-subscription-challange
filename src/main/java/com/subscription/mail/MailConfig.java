package com.subscription.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;



@Configuration
class MailConfig {

    @Bean
    public JavaMailSender javaMailSender(final MailProperties mailProperties) {
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailProperties.getMailSmtpHost());
        mailSender.setPort(mailProperties.getMailSmtpPort());

        mailSender.setUsername(mailProperties.getMailAccountUsername());
        mailSender.setPassword(mailProperties.getMailAccountPassword());

        final Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mailProperties.getMailTransportProtocol());
        props.put("mail.smtp.auth", mailProperties.getMailSmtpAuthEnabled());
        props.put("mail.smtp.starttls.enable", mailProperties.getMailSmtpStartTlsEnabled());
        props.put("mail.debug", mailProperties.getMailDebugEnabled());

        return mailSender;
    }

    @Bean
    public MailService mailService(final JavaMailSender javaMailSender, final MailProperties mailProperties) {
        return new MailService(mailProperties, javaMailSender);
    }
}
