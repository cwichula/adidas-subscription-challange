package com.subscription.mail;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MailProperties {

    private int mailSmtpPort;
    private String mailSmtpHost;
    private String mailAccountUsername;
    private String mailAccountPassword;
    private String mailTransportProtocol;
    private String mailSmtpAuthEnabled;
    private String mailSmtpStartTlsEnabled;
    private String mailDebugEnabled;

    MailProperties(@Value("${MAIL_SMTP_PORT}") final String mailSmtpPort,
                   @Value("${MAIL_SMTP_HOST}") final String mailSmtpHost,
                   @Value("${MAIL_ACCOUNT_USERNAME}") final String mailAccountUsername,
                   @Value("${MAIL_ACCOUNT_PASSWORD}") final String mailAccountPassword,
                   @Value("${MAIL_TRANSPORT_PROTOCOL}") final String mailTransportProtocol,
                   @Value("${MAIL_SMTP_AUTH_ENABLED}") final String mailSmtpAuthEnabled,
                   @Value("${MAIL_SMTP_STARTTLS_ENABLED}") final String mailSmtpStartTlsEnabled,
                   @Value("${MAIL_DEBUG_ENABLED}") final String mailDebugEnabled) {

        this.mailSmtpPort = Integer.parseInt(mailSmtpPort);
        this.mailSmtpHost = mailSmtpHost;
        this.mailAccountUsername = mailAccountUsername;
        this.mailAccountPassword = mailAccountPassword;
        this.mailTransportProtocol = mailTransportProtocol;
        this.mailSmtpAuthEnabled = mailSmtpAuthEnabled;
        this.mailSmtpStartTlsEnabled = mailSmtpStartTlsEnabled;
        this.mailDebugEnabled = mailDebugEnabled;
    }
}
