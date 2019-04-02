package com.subscription.mail;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
class KafkaProperties {

    private String kafkaTopicName;
    private String kafkaListenerGroupId;
    private String kafkaAddress;

    KafkaProperties(@Value("${KAFKA_TOPIC_NAME}") final String kafkaTopicName,
                    @Value("${KAFKA_LISTENER_GROUP_ID}") final String kafkaListenerGroupId,
                    @Value("${KAFKA_ADDRESS}") final String kafkaAddress) {
        this.kafkaTopicName = kafkaTopicName;
        this.kafkaListenerGroupId = kafkaListenerGroupId;
        this.kafkaAddress = kafkaAddress;
    }
}
