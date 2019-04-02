package com.subscription.mail;


import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

@AllArgsConstructor
public class KafkaService {
    private MailService mailService;

    @KafkaListener(topics = "${KAFKA_TOPIC_NAME}", groupId = "${KAFKA_LISTENER_GROUP_ID}")
    public void listen(final SubscriptionDTO subscriptionDTO) {

        mailService.sendConfirmation(subscriptionDTO.getMail());
    }
}
