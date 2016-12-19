package com.sample.core.listner;

import com.sample.core.entity.CommonDataEntity;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Component
public class CustomAuditingEntityListener {

    @PrePersist
    public void touchForCreate(CommonDataEntity entity) {
        Date now = new Date();
        entity.setDateCreated(now);
        entity.setLastUpdated(now);
    }

    @PreUpdate
    public void touchForUpdate(CommonDataEntity entity) {
        entity.setLastUpdated(new Date());
    }
}
