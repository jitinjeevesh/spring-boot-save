package com.sample.core.repository;

import com.sample.core.domain.BloodRequest;
import com.sample.core.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
}
