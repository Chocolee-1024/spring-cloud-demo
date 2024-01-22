package com.example.customer;

import com.example.request.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Choco Lee
 */
@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/register")
    public ResponseEntity<BaseResponse> registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        return ResponseEntity.ok(customerService.registerCustomer(request));

    }
}
