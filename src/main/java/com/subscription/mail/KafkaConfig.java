package com.subscription.mail;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
class KafkaConfig {

    @Bean
    public ConsumerFactory<String, SubscriptionDTO> consumerFactory(final KafkaProperties kafkaProperties) {
        final Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getKafkaAddress());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getKafkaListenerGroupId());

        return new DefaultKafkaConsumerFactory<>(props,
                                                 new StringDeserializer(),
                                                 new JsonDeserializer<>(SubscriptionDTO.class, false));
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SubscriptionDTO> kafkaListenerContainerFactory(
            final KafkaProperties kafkaProperties) {
        final ConcurrentKafkaListenerContainerFactory<String, SubscriptionDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }


}
