package com.example.lock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Choco Lee
 */
@Repository
public interface CheckAccountLockRepository extends JpaRepository<CheckAccountLock, Long> {

}
