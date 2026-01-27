package com.iglin.data_transmitter.adapter.in.scheduler;

import com.iglin.data_transmitter.application.DataTransitionOrchestrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataTransitionScheduler {

    private final DataTransitionOrchestrator dataTransitionOrchestrator;

    @Scheduled(initialDelay = 0, fixedDelay = 1000 * 60 * 60)
    public void transitData() {
        log.info("Starting data transitioning.");
//        dataTransitionOrchestrator.transitData();
    }

}
