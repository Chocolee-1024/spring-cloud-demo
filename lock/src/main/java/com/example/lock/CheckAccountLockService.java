package com.example.lock;


import com.example.lock.request.CheckAccountLockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Choco Lee
 */
@Service
@RequiredArgsConstructor
public class CheckAccountLockService {
    private final CheckAccountLockRepository checkAccountLockRepository;

    public CheckAccountLockResponse isCustomerLocked(Long customerId) {
        try {
            checkAccountLockRepository.save(
                    CheckAccountLock.builder()
                            .customerId(customerId)
                            .isLock(false)
                            .build());
            return new CheckAccountLockResponse(false);
        }catch (Exception e) {
            return new CheckAccountLockResponse(true);
        }
    }
}
