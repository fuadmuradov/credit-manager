package org.example.creditmanager.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.creditmanager.entity.OfferEntity;
import org.example.creditmanager.entity.StatusHistoryEntity;
import org.example.creditmanager.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class CreditResponse {
    private Long id;
    private Integer term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal requestedAmount;
    private BigDecimal amount;
    private Status status;
    private LocalDateTime checkDate;
    private List<HistoryResponse> statusHistories;
    private List<OfferResponse> offers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
