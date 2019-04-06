package com.subscription.mail;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@AllArgsConstructor
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    private MailProperties mailProperties;
    private JavaMailSender javaMailSender;

    @KafkaListener(topics = "${KAFKA_TOPIC_NAME}", groupId = "${KAFKA_LISTENER_GROUP_ID}")
    public void listen(final SubscriptionDTO subscriptionDTO) {
        logger.info("Consuming subscription: {}", subscriptionDTO);
        sendConfirmation(subscriptionDTO.getEmail());
    }

    @Async
    void sendConfirmation(final String to) {

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(mailProperties.getMailMessageTopic());
        message.setText(mailProperties.getMailMessageDescription());
        javaMailSender.send(message);

    }
}
