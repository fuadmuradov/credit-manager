package org.example.creditmanager.controller;

import lombok.RequiredArgsConstructor;
import org.example.creditmanager.model.client.UpdateProduct;
import org.example.creditmanager.model.requset.CreditRequest;
import org.example.creditmanager.model.response.CreditResponse;
import org.example.creditmanager.service.abstraction.CreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/credit-manager/credit")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;
    @GetMapping
    public ResponseEntity<List<CreditResponse>> getCredits() {
        return ResponseEntity.ok().body(
                creditService.getCredits()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditResponse> getCreditById(@PathVariable long id) {
        return ResponseEntity.ok().body(
                creditService.getCredit(id)
        );
    }

    @PostMapping
    public ResponseEntity<Void> createCredit(@RequestBody CreditRequest creditRequest) {
        creditService.saveCredit(creditRequest);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> updateCredit(@RequestBody UpdateProduct creditRequest) {
        return ResponseEntity.ok().build();
    }
}
