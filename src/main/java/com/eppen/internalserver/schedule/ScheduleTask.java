package com.eppen.internalserver.schedule;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
@Component
public class ScheduleTask {

    @Scheduled(fixedDelay = 5000)
    public void run() {

    }

}
