package org.example.creditmanager.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class OfferResponse {
    private Long id;
    private int term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal amount;
    private Boolean accepted;
    private CreditResponse credit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
