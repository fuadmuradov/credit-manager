package org.example.creditmanager.client;

import org.example.creditmanager.model.client.OfferResponseDto;
import org.example.creditmanager.model.client.ProductRequestDto;
import org.example.creditmanager.model.client.UpdateProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.example.creditmanager.decoder.CustomErrorDecoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "${ms-offer.name}", url = "${ms-offer.url}", configuration = CustomErrorDecoder.class)
public interface OfferClient {
    @PostMapping("/v1/credit-conveyor/offers")
    OfferResponseDto getOffer(ProductRequestDto requestDto);
    @PutMapping("/v1/credit-conveyor/offers")
    void updateOffer(UpdateProduct updateProduct);

}
