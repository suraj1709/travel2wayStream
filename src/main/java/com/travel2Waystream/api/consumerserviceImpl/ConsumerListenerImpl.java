package com.travel2Waystream.api.consumerserviceImpl;

import com.travel2Waystream.api.constant.ApplicationConstant;
import com.travel2Waystream.api.consumerservice.ConsumerListener;
import com.travel2Waystream.api.model.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListenerImpl implements ConsumerListener {

    private final Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    @KafkaListener(topics = ApplicationConstant.TOPIC_NAME,groupId = ApplicationConstant.GROUP_ID,containerFactory = "kafkaListenerContainerFactory1")
    public void consume1(Place place) {
        log.info("Message Received from Topic : {}",ApplicationConstant.TOPIC_NAME);
        System.out.println("message received 1:"+place);



    }

    @Override
    @KafkaListener(topics = ApplicationConstant.TOPIC_NAME,groupId = ApplicationConstant.GROUP_ID1,containerFactory = "kafkaListenerContainerFactory2")
    public void consume2(Place place) {
        log.info("Message Received from Topic : {}",ApplicationConstant.TOPIC_NAME);
        System.out.println("message received 2 :"+place);

    }
}
