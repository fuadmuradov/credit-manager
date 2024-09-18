package org.example.creditmanager.service.abstraction;

import org.example.creditmanager.model.requset.CustomerRequest;
import org.example.creditmanager.model.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomer(Long id);
    CustomerResponse getCustomerByPin(String pin);
    List<CustomerResponse> getAllCustomers();
}
