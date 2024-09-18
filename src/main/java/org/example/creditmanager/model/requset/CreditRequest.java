package org.example.creditmanager.model.requset;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.creditmanager.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class CreditRequest {
    private Integer term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal requestedAmount;
    private BigDecimal amount;
    private Status status;
    private Long customerId;
    private LocalDateTime checkDate;
}
