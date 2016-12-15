package com.sample.core.domain;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_user", nullable = false)
    private String userRole;

    @Column(name = "role_description")
    private String roleDescription;

    public Role() {
    }

    public Role(Builder builder) {
        this.userRole = builder.userRole;
        this.roleDescription = builder.roleDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public static final class Builder {
        private Long id;

        private String userRole;

        private String roleDescription;

        public Long getId() {
            return id;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public String getUserRole() {
            return userRole;
        }

        public Builder setUserRole(String userRole) {
            this.userRole = userRole;
            return this;
        }

        public String getRoleDescription() {
            return roleDescription;
        }

        public Builder setRoleDescription(String roleDescription) {
            this.roleDescription = roleDescription;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }

}
