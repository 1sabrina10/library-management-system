package com.sabrina.librarymanagementsystem.kafka.producer;

import com.sabrina.librarymanagementsystem.kafka.LoanEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoanProducer {

    private final KafkaTemplate<String, LoanEvent> kafkaTemplate;
    private static final String TOPIC = "loan-events";
    public LoanProducer(KafkaTemplate<String, LoanEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLoanEvent(LoanEvent event) {
       kafkaTemplate.send(TOPIC, String.valueOf(event.getLoanId()), event);
    }
}
