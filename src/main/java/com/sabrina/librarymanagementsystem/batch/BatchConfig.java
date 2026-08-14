package com.sabrina.librarymanagementsystem.batch;

import com.sabrina.librarymanagementsystem.entity.Loan;
import com.sabrina.librarymanagementsystem.entity.LoanStatus;
import com.sabrina.librarymanagementsystem.repository.LoanRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class BatchConfig {

    @Bean
    public Job loanNotificationJob(
            JobRepository jobRepository,
            Step loanNotificationStep
    ) {
        return new JobBuilder("loanNotificationJob", jobRepository)
                .start(loanNotificationStep)
                .build();
    }

    @Bean
    @StepScope
    public ItemReader<Loan> loanReader(
            LoanRepository loanRepository
    ) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime next24Hours = now.plusHours(24);

        List<Loan> loans =
                loanRepository.findByLoanStatusAndDueDateBetweenAndReminderSentFalse(
                        LoanStatus.BORROWED,
                        now,
                        next24Hours
                );

        System.out.println("Loans trouvés : " + loans.size());

        return new ListItemReader<>(loans);
    }

    @Bean
    @StepScope
    public ItemProcessor<Loan, Loan> loanProcessor() {

        return loan -> {

            System.out.println(
                    "PROCESSOR : Loan #" + loan.getId()
                            + " -> " + loan.getUser().getEmail()
            );

            return loan;
        };
    }

    @Bean
    public ItemWriter<Loan> loanWriter(
            EmailService emailService,
            LoanRepository loanRepository
    ) {

        return items -> {

            for (Loan loan : items) {

                emailService.sendLoanReminder(
                        loan.getUser().getEmail(),
                        loan.getUser().getFirstname()
                                + " "
                                + loan.getUser().getLastname(),
                        loan.getBook().getTitle(),
                        loan.getDueDate()
                );

                loan.setReminderSent(true);

                loanRepository.save(loan);

                System.out.println(
                        "WRITER : notification envoyée à "
                                + loan.getUser().getEmail()
                );
            }
        };
    }

    @Bean
    public Step loanNotificationStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            ItemReader<Loan> loanReader,
            ItemProcessor<Loan, Loan> loanProcessor,
            ItemWriter<Loan> loanWriter
    ) {

        return new StepBuilder("loanNotificationStep", jobRepository)
                .<Loan, Loan>chunk(10, transactionManager)
                .reader(loanReader)
                .processor(loanProcessor)
                .writer(loanWriter)
                .build();
    }

}