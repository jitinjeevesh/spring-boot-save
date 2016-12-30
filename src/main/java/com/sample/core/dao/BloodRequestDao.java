package com.sample.core.dao;

import com.sample.core.domain.BloodRequest;
import com.sample.core.repository.BloodRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<BloodRequest> list() {
        Pageable pageable = new PageRequest(0, 30);
        return bloodRequestRepository.findAll(pageable).getContent();
    }
}
