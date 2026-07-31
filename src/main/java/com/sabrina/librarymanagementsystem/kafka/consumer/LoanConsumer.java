package com.sabrina.librarymanagementsystem.kafka.consumer;

import com.sabrina.librarymanagementsystem.kafka.LoanEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LoanConsumer {

    @KafkaListener(topics = "loan-events", groupId = "library-group")

    public void consume(LoanEvent event) {

        System.out.println("Loan event received");
        System.out.println("Loan id : " + event.getLoanId());
        System.out.println("User id : " + event.getUserId());
        System.out.println("Book id : " + event.getBookId());
        System.out.println("Action : " + event.getAction());
    }
}
