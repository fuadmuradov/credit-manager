package org.example.creditmanager.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.creditmanager.entity.CustomerEntity;
import org.example.creditmanager.exception.NotFoundException;
import org.example.creditmanager.model.requset.CustomerRequest;
import org.example.creditmanager.model.response.CustomerResponse;
import org.example.creditmanager.repository.CustomerRepository;
import org.example.creditmanager.service.abstraction.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.creditmanager.exception.ErrorConstants.CUSTOMER_NOT_FOUND_EXCEPTION;
import static org.example.creditmanager.mapper.CustomerMapper.CUSTOMER_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceHandler implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(CustomerRequest customerRequest) {
        log.info("Save customer request: {}", customerRequest);
        var customer = CUSTOMER_MAPPER.mapToEntity(customerRequest);
        customer.setIsDeleted(false);
        customerRepository.save(customer);
    }

    @Override
    public CustomerResponse getCustomer(Long id) {
        var customer = getCustomerEntityIfExist(id);
        return CUSTOMER_MAPPER.mapToResponse(customer);
    }

    @Override
    public CustomerResponse getCustomerByPin(String pin) {
        var customerEntity = customerRepository
                .findByPin(pin).orElseThrow(() -> new NotFoundException(CUSTOMER_NOT_FOUND_EXCEPTION.getMessage(), CUSTOMER_NOT_FOUND_EXCEPTION.getCode()));
        return CUSTOMER_MAPPER.mapToResponse(customerEntity);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        var customers = customerRepository.findAll();
        return customers.stream().map(CUSTOMER_MAPPER::mapToResponse).toList();
    }

    CustomerEntity getCustomerEntityIfExist(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(CUSTOMER_NOT_FOUND_EXCEPTION.getMessage(), CUSTOMER_NOT_FOUND_EXCEPTION.getCode()));

    }
}
