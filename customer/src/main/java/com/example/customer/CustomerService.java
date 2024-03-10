package com.example.customer;

import com.example.request.BaseResponse;
import com.example.request.CheckLockResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Choco Lee
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public BaseResponse registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        try {
            customerRepository.save(customer);
            CheckLockResponse checkLockResponse = restTemplate.getForObject(
                    "http://LOCK/api/lock/checkCustomer/{customerId}",
                    CheckLockResponse.class,
                    customer.getId()
            );

            if(checkLockResponse.isLock()) {
                throw  new IllegalStateException("Account is locked");
            } else {
                return BaseResponse.SUCCESS();
            }
        } catch (Exception e) {
            log.error("error s customer {}", customer, e);
            return BaseResponse.FAILED();
        }
    }
}
