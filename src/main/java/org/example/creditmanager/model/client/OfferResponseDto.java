package org.example.creditmanager.model.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class OfferResponseDto {
    private Long conveyorId;
    private String checkDate;
    private List<ProductRequestDto> products;
}
