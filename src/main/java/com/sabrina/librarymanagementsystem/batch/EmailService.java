package com.sabrina.librarymanagementsystem.batch;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendLoanReminder(
            String email,
            String userName,
            String bookTitle,
            LocalDateTime dueDate
    ) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm");

        String formattedDueDate = dueDate.format(formatter);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);

        message.setSubject(
                "Rappel : votre emprunt arrive à échéance"
        );

        message.setText(
                "Bonjour " + userName + ",\n\n" +
                        "Nous vous rappelons que votre emprunt du livre \"" +
                        bookTitle +
                        "\" arrive à échéance le " +
                        formattedDueDate +
                        ".\n\n" +
                        "Merci de penser à retourner le livre avant cette date.\n\n" +
                        "LibraryMS"
        );

        mailSender.send(message);

        System.out.println(
                "Email envoyé à : " + email
        );
    }
}