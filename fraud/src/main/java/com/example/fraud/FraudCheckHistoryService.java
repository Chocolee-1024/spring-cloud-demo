package com.example.fraud;


import com.example.fraud.request.FraudResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Choco Lee
 */
@Service
@RequiredArgsConstructor
public class FraudCheckHistoryService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudResponse isFraudulentCustomer(Long customerId) {
        try {
            fraudCheckHistoryRepository.save(
                    FraudCheckHistory.builder()
                            .customerId(customerId)
                            .createdAt(LocalDateTime.now())
                            .isFraudster(false)
                            .build());
            return new FraudResponse(false);
        }catch (Exception e) {
            return new FraudResponse(true);
        }
    }
}
