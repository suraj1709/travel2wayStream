package com.travel2Waystream.api.config;

import com.travel2Waystream.api.constant.ApplicationConstant;
import com.travel2Waystream.api.model.Place;
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
public class ConsumerConfiguration {

    @Bean
    public ConsumerFactory<String, Place> consumerFactory1()
    {
        Map<String,Object> config= new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationConstant.LOCAL_HOST_PORT);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,ApplicationConstant.GROUP_ID);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new JsonDeserializer<>(Place.class));
    }
     @Bean(name = "kafkaListenerContainerFactory1")
    public ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory1()
    {
        ConcurrentKafkaListenerContainerFactory<String,Place> factory=new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory1());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Place> consumerFactory2()
    {
        Map<String,Object> config= new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationConstant.LOCAL_HOST_PORT);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,ApplicationConstant.GROUP_ID);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new JsonDeserializer<>(Place.class));
    }
    @Bean(name = "kafkaListenerContainerFactory2")
    public ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory2()
    {
        ConcurrentKafkaListenerContainerFactory<String,Place> factory=new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory2());
        return factory;
    }
}
