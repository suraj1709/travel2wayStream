package com.travel2Waystream.api.producerserviceImpl;

import com.travel2Waystream.api.constant.ApplicationConstant;
import com.travel2Waystream.api.model.Place;
import com.travel2Waystream.api.Producerservice.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerTemplateImpl implements ProducerTemplate {

    @Autowired
    KafkaTemplate<String, Place> kafkaTemplate;

    private final Logger log=LoggerFactory.getLogger(this.getClass());


    @Override
    public String produce(Place place)
    {
        kafkaTemplate.send(ApplicationConstant.TOPIC_NAME,place);
        log.info("Message Send to Topic : {}",ApplicationConstant.TOPIC_NAME);
        return "Successfully Received";
    }




}
