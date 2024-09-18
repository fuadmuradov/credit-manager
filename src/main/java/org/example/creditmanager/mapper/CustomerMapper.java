package org.example.creditmanager.mapper;

import org.example.creditmanager.entity.CustomerEntity;
import org.example.creditmanager.model.requset.CustomerRequest;
import org.example.creditmanager.model.response.CustomerResponse;

import static org.example.creditmanager.mapper.CreditMapper.CREDIT_MAPPER;

public enum CustomerMapper {
    CUSTOMER_MAPPER;
    public CustomerEntity mapToEntity(CustomerRequest customerRequest){
        return CustomerEntity.builder()
                .pin(customerRequest.getPin())
                .fullName(customerRequest.getFullName())
                .phoneNumber(customerRequest.getPhoneNumber())
                .build();
    }

    public CustomerResponse mapToResponse(CustomerEntity customerEntity){
        return CustomerResponse.builder()
                .id(customerEntity.getId())
                .pin(customerEntity.getPin())
                .fullName(customerEntity.getFullName())
                .phoneNumber(customerEntity.getPhoneNumber())
                .credits(customerEntity.getCredits().stream().map(CREDIT_MAPPER::mapToResponse).toList())
                .createdAt(customerEntity.getCreatedAt())
                .updatedAt(customerEntity.getUpdatedAt())
                .build();
    }
}
