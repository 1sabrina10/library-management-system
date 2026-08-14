package com.sabrina.librarymanagementsystem.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchLauncher implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job loanNotificationJob;

    public BatchLauncher(
            JobLauncher jobLauncher,
            Job loanNotificationJob
    ) {
        this.jobLauncher = jobLauncher;
        this.loanNotificationJob = loanNotificationJob;
    }

    @Override
    public void run(String... args) throws Exception {

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
    }
}