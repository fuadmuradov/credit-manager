package org.example.creditmanager.scheduler;

import lombok.RequiredArgsConstructor;
import org.example.creditmanager.enums.Status;
import org.example.creditmanager.repository.CreditRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CheckExpiredDate {
    private final CreditRepository creditRepository;
    @Scheduled(cron = "0 0 0 * * ?") // Every day at midnight
    public void removeExpiredCheckDates() {
        LocalDateTime now = LocalDateTime.now();
        var credits = creditRepository.findAllByCheckDateBefore(LocalDateTime.now());
        var creditsToDelete = credits.stream()
                .filter(credit -> credit.getStatusHistories().stream()
                        .anyMatch(history -> history.getStatus() == Status.DRAFT))
                .toList();
        creditRepository.deleteAll(creditsToDelete);
    }
}
