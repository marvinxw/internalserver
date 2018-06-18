package com.eppen.internalserver;

import com.eppen.internalserver.schedule.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class InternalserverApplication {

    @Autowired
    private ScheduleTask scheduleTask;

    public static void main(String[] args) {
        SpringApplication.run(InternalserverApplication.class, args);
    }

    @Autowired
    private void run() {
        scheduleTask.run();
    }
}
