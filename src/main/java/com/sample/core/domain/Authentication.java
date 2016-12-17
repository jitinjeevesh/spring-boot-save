package com.sample.core.domain;

import javax.persistence.*;

@Entity
@Table(name = "authentication")
public abstract class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static abstract class Builder {
        public abstract Authentication build();
    }
}
