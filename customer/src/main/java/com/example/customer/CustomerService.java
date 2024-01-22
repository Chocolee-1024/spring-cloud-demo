package com.example.customer;

import com.example.request.BaseResponse;
import com.example.request.FraudResponse;
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
        log.info("new customer registration {}", request);
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        try {
            //如果沒用 Flush 無法拿到 Id
            customerRepository.saveAndFlush(customer);
            FraudResponse fraudResponse = restTemplate.getForObject(
                    "http://localhost:8081/api/fraud/checkCustomer/{customerId}",
                    FraudResponse.class,
                    customer.getId()
            );

            if(fraudResponse.isFraud()) {
                throw  new IllegalStateException("fraudster");
            } else {
                return BaseResponse.SUCCESS();
            }
        } catch (Exception e) {
            log.error("error s customer {}", customer, e);
            return BaseResponse.FAILED();
        }
    }
}
