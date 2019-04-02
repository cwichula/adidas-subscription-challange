package com.subscription.mail;


import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

@AllArgsConstructor
public class KafkaService {

    private MailService mailService;

    @KafkaListener(topics = "mail-topic", groupId = "mail-group-id")
    public void listen(final SubscriptionDTO subscriptionDTO) {

        mailService.sendConfirmation(
                subscriptionDTO.getMail(),
                "New subscription!",
                String.format("Congratulations %s! You have just subscribed to Adidas Newsletter!", subscriptionDTO.getFirstName()));
    }
}
