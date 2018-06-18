package com.eppen.internalserver;

import com.eppen.internalserver.schedule.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
public class InternalserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternalserverApplication.class, args);
    }
}
