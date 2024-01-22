package com.example.customer;

import com.example.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Choco Lee
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public BaseResponse registerCustomer(CustomerRegistrationRequest request) {
        log.info("new customer registration {}", request);
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();

        try {
            customerRepository.save(customer);
            return BaseResponse.SUCCESS();
        }catch (Exception e) {
            log.error("error s customer {}", customer, e);
            return BaseResponse.FAILED();
        }
    }
}
