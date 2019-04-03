package com.subscription.mail;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@AllArgsConstructor
public class MailService {

    private MailProperties mailProperties;
    private JavaMailSender javaMailSender;

    @KafkaListener(topics = "${KAFKA_TOPIC_NAME}", groupId = "${KAFKA_LISTENER_GROUP_ID}")
    public void listen(final SubscriptionDTO subscriptionDTO) {
        sendConfirmation(subscriptionDTO.getEmail());
    }

    void sendConfirmation(final String to) {

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(mailProperties.getMailMessageTopic());
        message.setText(mailProperties.getMailMessageDescription());
        javaMailSender.send(message);

    }
}
