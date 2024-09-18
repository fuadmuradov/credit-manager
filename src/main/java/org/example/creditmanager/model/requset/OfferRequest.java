package org.example.creditmanager.model.requset;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
public class OfferRequest {
    private int term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal amount;
    private Boolean accepted;
    private Long creditId;
}
