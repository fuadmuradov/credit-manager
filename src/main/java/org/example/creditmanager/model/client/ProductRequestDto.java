package org.example.creditmanager.model.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
public class ProductRequestDto {
    private int term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    private BigDecimal amount;
    private Long productId;
}
