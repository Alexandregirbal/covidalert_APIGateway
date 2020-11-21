package polytech.covidalert.kafka;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
//bin/zookeeper-server-start.sh config/zookeeper.properties
//bin/kafka-server-start.sh config/server.properties
@Service
public class KafkaProducer {

    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    KafkaProducer(KafkaTemplate<String,Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Object message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }

}
