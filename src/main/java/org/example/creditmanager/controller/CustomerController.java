package org.example.creditmanager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.creditmanager.model.requset.CustomerRequest;
import org.example.creditmanager.model.response.CustomerResponse;
import org.example.creditmanager.service.abstraction.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/credit-manager/customer")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("Controller Save customer: {}", customerRequest);
        customerService.saveCustomer(customerRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomers() {
        return ResponseEntity.ok().body(
                customerService.getAllCustomers()
        );
    }
}
