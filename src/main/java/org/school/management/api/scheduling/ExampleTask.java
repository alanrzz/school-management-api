package org.school.management.api.scheduling;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@EnableScheduling
public class ExampleTask {

    @Transactional
    @Async
    @Scheduled(initialDelayString = "${scheduling.initial-delay-string}", fixedDelayString = "${scheduling.fixed-delay-string}")
    public void firstTask() {
        // TODO
    }
}
