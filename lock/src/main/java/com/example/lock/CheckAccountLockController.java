package com.example.lock;

import com.example.lock.request.CheckAccountLockResponse;
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
@RequestMapping("api/lock")
@RequiredArgsConstructor
public class CheckAccountLockController {
    private final CheckAccountLockService checkAccountLockService;

    @GetMapping( "/checkCustomer/{customerId}")
    public ResponseEntity<CheckAccountLockResponse> isCustomerLocked(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(checkAccountLockService.isCustomerLocked(customerId));
    }
}
