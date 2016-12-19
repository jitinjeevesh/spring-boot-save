package com.sample.core.dao;

import com.sample.core.domain.BloodRequest;
import com.sample.core.repository.BloodRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BloodRequestDao implements Dao {

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    public BloodRequest get(Long id) {
        return bloodRequestRepository.findOne(id);
    }

    public BloodRequest save(BloodRequest bloodRequest) {
        return bloodRequestRepository.save(bloodRequest);
    }
}
