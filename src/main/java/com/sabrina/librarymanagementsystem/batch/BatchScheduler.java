package com.sabrina.librarymanagementsystem.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchScheduler {

    private final JobLauncher jobLauncher;
    private final Job loanNotificationJob;

    public BatchScheduler(
            JobLauncher jobLauncher,
            Job loanNotificationJob
    ) {
        this.jobLauncher = jobLauncher;
        this.loanNotificationJob = loanNotificationJob;
    }

    @Scheduled(cron = "${batch.loan-notification.cron}")
    public void runLoanNotificationJob() {

        try {

            JobParameters parameters =
                    new JobParametersBuilder()
                            .addLong(
                                    "run.id",
                                    System.currentTimeMillis()
                            )
                            .toJobParameters();

            jobLauncher.run(
                    loanNotificationJob,
                    parameters
            );

            System.out.println(
                    "=== BATCH NOTIFICATION LANCE ==="
            );

        } catch (Exception e) {

            System.err.println(
                    "Erreur lancement Batch : "
                            + e.getMessage()
            );
        }
    }
}
