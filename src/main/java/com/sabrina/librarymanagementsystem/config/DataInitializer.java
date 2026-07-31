/*

package com.sabrina.librarymanagementsystem.config;

import com.sabrina.librarymanagementsystem.kafka.LoanEvent;
import com.sabrina.librarymanagementsystem.kafka.producer.LoanProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

  @Bean
CommandLineRunner testKafka(LoanProducer producer) {
    return args -> {

        LoanEvent event = LoanEvent.newBuilder()
                .setLoanId(1L)
                .setUserId(2L)
                .setBookId(3L)
                .setAction("BORROWED")
                .build();

        producer.sendLoanEvent(event);
    };
}
}

*/
