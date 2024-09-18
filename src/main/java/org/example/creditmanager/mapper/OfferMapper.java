package org.example.creditmanager.mapper;

import org.example.creditmanager.entity.CreditEntity;
import org.example.creditmanager.entity.OfferEntity;
import org.example.creditmanager.model.client.ProductRequestDto;
import org.example.creditmanager.model.requset.OfferRequest;
import org.example.creditmanager.model.response.OfferResponse;

import java.math.BigDecimal;

public enum OfferMapper {
    OFFER_MAPPER;
    public OfferEntity mapToEntity(OfferRequest offerRequest) {
        return OfferEntity.builder()
                .term(offerRequest.getTerm())
                .interest(offerRequest.getInterest())
                .amount(offerRequest.getAmount())
                .accepted(false)
                .monthlyPayment(offerRequest.getMonthlyPayment())
                .build();
    }
    public OfferResponse mapToResponse(OfferEntity offerEntity) {
        return OfferResponse.builder()
                .term(offerEntity.getTerm())
                .interest(offerEntity.getInterest())
                .amount(offerEntity.getAmount())
                .accepted(offerEntity.getAccepted())
                .monthlyPayment(offerEntity.getMonthlyPayment())
                .id(offerEntity.getId())
                .createdAt(offerEntity.getCreatedAt())
                .updatedAt(offerEntity.getUpdatedAt())
                .build();
    }

    public OfferEntity mapProductToOfferEntity(ProductRequestDto request){
        if (request.getAmount() == null
                || request.getAmount().compareTo(BigDecimal.valueOf(300))<0)
            request.setAmount(BigDecimal.valueOf(300));
        return OfferEntity.builder()
                .amount(request.getAmount())
                .term(request.getTerm())
                .accepted(false)
                .interest(request.getInterest())
                .monthlyPayment(request.getMonthlyPayment())
                .build();
    }
}
