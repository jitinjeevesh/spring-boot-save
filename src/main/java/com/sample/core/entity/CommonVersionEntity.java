package com.sample.core.entity;

import com.sample.core.listner.CustomAuditingEntityListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(CustomAuditingEntityListener.class)
public abstract class CommonVersionEntity implements BaseEntity {
    @Transient
    public static final String DATE_CREATED = "dateCreated";
    @Transient
    public static final String LAST_UPDATED = "lastUpdated";

    @CreatedDate
    @Column(nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(nullable = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(nullable = false)
    @Version
    private Long version;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreate) {
        this.dateCreated = dateCreate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
