package com.travel2Waystream.api.webapp;


import com.travel2Waystream.api.Producerservice.ProducerTemplate;
import com.travel2Waystream.api.model.Place;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/travel2way/producer")
@Tag(name="kafka Producer Api",description ="kafka Producer Api")
public class Travel2wayController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Operation(description = "Produce message into kafka")
    @PostMapping("/post")
    public ResponseEntity<String> postTravel(@RequestBody Place place)
    {
        producerTemplate.produce(place);
        return new ResponseEntity<>("Send successfully",HttpStatus.ACCEPTED);
    }
}
