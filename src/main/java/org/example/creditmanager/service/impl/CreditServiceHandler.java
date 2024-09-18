package org.example.creditmanager.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.creditmanager.client.OfferClient;
import org.example.creditmanager.entity.StatusHistoryEntity;
import org.example.creditmanager.enums.Status;
import org.example.creditmanager.exception.NotFoundException;
import org.example.creditmanager.model.client.ProductRequestDto;
import org.example.creditmanager.model.client.UpdateProduct;
import org.example.creditmanager.model.requset.CreditRequest;
import org.example.creditmanager.model.response.CreditResponse;
import org.example.creditmanager.model.response.HistoryResponse;
import org.example.creditmanager.repository.CreditRepository;
import org.example.creditmanager.repository.CustomerRepository;
import org.example.creditmanager.service.abstraction.CreditService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.example.creditmanager.exception.ErrorConstants.CREDIT_NOT_FOUND_EXCEPTION;
import static org.example.creditmanager.exception.ErrorConstants.CUSTOMER_NOT_FOUND_EXCEPTION;
import static org.example.creditmanager.mapper.CreditMapper.CREDIT_MAPPER;
import static org.example.creditmanager.mapper.HistoryMapper.HISTORY_MAPPER;
import static org.example.creditmanager.mapper.OfferMapper.OFFER_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditServiceHandler implements CreditService {
    private final OfferClient offerClient;
    private final CreditRepository creditRepository;
    private final CustomerRepository customerRepository;

    @PostConstruct
    public void logOffer(){
        var msOffer = offerClient.getOffer(ProductRequestDto.builder()
                .build());
        log.info("ms-Offer: {}", msOffer.toString());
    }
    @Override
    public void saveCredit(CreditRequest creditRequest) {
        log.info("Started Save credit: {}", creditRequest);
        var credit = CREDIT_MAPPER.mapToEntity(creditRequest);

        var msOffer = offerClient.getOffer(ProductRequestDto.builder()
                .build());
        log.info("Ms-offer: {}", msOffer);
        credit.setCheckDate(LocalDateTime.parse(msOffer.getCheckDate(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        var offers = msOffer.getProducts().stream().map(OFFER_MAPPER::mapProductToOfferEntity).toList();
        offers.forEach(it -> it.setCredit(credit));
        credit.setOffers(offers);
        var status = StatusHistoryEntity.builder().status(Status.DRAFT)
                .credit(credit)
                .build();
        credit.setStatusHistories(List.of(status));
        credit.setCustomer(customerRepository.findById(creditRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException(CUSTOMER_NOT_FOUND_EXCEPTION.getMessage(), CUSTOMER_NOT_FOUND_EXCEPTION.getCode()))
);
        credit.setIsDeleted(false);
        log.info("Save credit: {}", credit);
        creditRepository.save(credit);
        log.info("Credit saved: {}", credit);
    }

    @Override
    public CreditResponse getCredit(Long Id) {
        log.info("Get customer: {}", Id);
        var creditEntity = creditRepository.findById(Id).orElseThrow(() -> new NotFoundException(CREDIT_NOT_FOUND_EXCEPTION.getMessage(), CREDIT_NOT_FOUND_EXCEPTION.getCode()));
        log.info("Credit found: {}", creditEntity.toString());
        var credit =  CREDIT_MAPPER.mapToResponse(creditEntity);
        log.info("Credit retrieved: {}", credit);
        //var status = creditEntity.getStatusHistories().stream().map(HISTORY_MAPPER::mapToResponse).toList();
//        log.info("Status histories: {}", status);
//        credit.setStatusHistories(status);
        log.info("returned Credit retrieved: {}", credit);
        return credit;
    }

    @Override
    public List<CreditResponse> getCredits() {
        log.info("Get credits");
        var credit = creditRepository.findAll();
        credit.forEach(creditEntity -> {
            log.info("Get credits after find all: {}", credit);
        });

        return credit.stream().map(CREDIT_MAPPER::mapToResponse).toList();
    }

    @Override
    public void updateOfferProduct(UpdateProduct updateProduct) {
        offerClient.updateOffer(updateProduct);
    }

}
