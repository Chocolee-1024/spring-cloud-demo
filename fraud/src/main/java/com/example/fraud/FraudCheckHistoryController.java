package com.example.fraud;

import com.example.fraud.request.FraudResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Choco Lee
 */
@RestController
@RequestMapping("api/fraud")
@RequiredArgsConstructor
public class FraudCheckHistoryController {
    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "/checkCustomer/{customerId}")
    public ResponseEntity<FraudResponse> isFraudulentCustomer(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(fraudCheckHistoryService.isFraudulentCustomer(customerId));
    }
}
