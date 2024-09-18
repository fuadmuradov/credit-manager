package org.example.creditmanager.mapper;

import org.example.creditmanager.entity.CreditEntity;
import org.example.creditmanager.model.client.ProductRequestDto;
import org.example.creditmanager.model.requset.CreditRequest;
import org.example.creditmanager.model.response.CreditResponse;

import static org.example.creditmanager.mapper.HistoryMapper.HISTORY_MAPPER;
import static org.example.creditmanager.mapper.OfferMapper.OFFER_MAPPER;

public enum CreditMapper {
    CREDIT_MAPPER;
    public CreditEntity mapToEntity(CreditRequest creditRequest){
        return CreditEntity.builder()
                .amount(creditRequest.getAmount())
                .term(creditRequest.getTerm())
                .interest(creditRequest.getInterest())
                .monthlyPayment(creditRequest.getMonthlyPayment())
                .status(creditRequest.getStatus())
                .requestedAmount(creditRequest.getRequestedAmount())
                .build();
    }



    public CreditResponse mapToResponse(CreditEntity creditEntity){
        return CreditResponse.builder()
                .id(creditEntity.getId())
                .amount(creditEntity.getAmount())
                .term(creditEntity.getTerm())
                .interest(creditEntity.getInterest())
                .monthlyPayment(creditEntity.getMonthlyPayment())
                .status(creditEntity.getStatus())
                .requestedAmount(creditEntity.getRequestedAmount())
                .checkDate(creditEntity.getCheckDate())
                .createdAt(creditEntity.getCreatedAt())
                .updatedAt(creditEntity.getUpdatedAt())
                .offers(creditEntity.getOffers().stream().map(OFFER_MAPPER::mapToResponse).toList())
                .statusHistories(creditEntity.getStatusHistories().stream().map(HISTORY_MAPPER::mapToResponse).toList())
                .build();
    }
}
