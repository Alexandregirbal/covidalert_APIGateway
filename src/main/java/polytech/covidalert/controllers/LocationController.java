package polytech.covidalert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import polytech.covidalert.kafka.KafkaLocation;
import polytech.covidalert.kafka.KafkaProducer;
import polytech.covidalert.models.Location;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/api/locations")
public class LocationController {
    private final KafkaProducer kafkaProducer;

    @Autowired
    LocationController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/send", produces = "application/json")
    public KafkaLocation sendLocalisationToKafkaTopic(@RequestBody final KafkaLocation kafkaLocation) {
        this.kafkaProducer.sendMessage(kafkaLocation,"locations");
        return kafkaLocation;
    }

}
