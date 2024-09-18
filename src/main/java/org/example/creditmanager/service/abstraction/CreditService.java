package org.example.creditmanager.service.abstraction;

import org.example.creditmanager.model.client.UpdateProduct;
import org.example.creditmanager.model.requset.CreditRequest;
import org.example.creditmanager.model.response.CreditResponse;
import org.example.creditmanager.model.response.CustomerResponse;

import java.util.List;

public interface CreditService {
    void saveCredit(CreditRequest creditRequest);
    CreditResponse getCredit(Long Id);
    List<CreditResponse> getCredits();
    void updateOfferProduct(UpdateProduct updateProduct);
}
