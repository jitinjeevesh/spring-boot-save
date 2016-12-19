package com.sample.core.domain;

import com.sample.core.entity.CommonDataEntity;

import javax.persistence.*;

@Entity
@Table(name = "authentication")
public abstract class Authentication extends CommonDataEntity{

    public static abstract class Builder {
        public abstract Authentication build();
    }
}
