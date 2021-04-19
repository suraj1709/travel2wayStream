package com.travel2Waystream.api.webapp;


import com.travel2Waystream.api.Producerservice.ProducerTemplate;
import com.travel2Waystream.api.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/travel2way/producer")
public class Travel2wayController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/post")
    public ResponseEntity<String> postTravel(@RequestBody Place place)
    {
        producerTemplate.produce(place);
        return new ResponseEntity<>("Send successfully",HttpStatus.ACCEPTED);
    }
}
