package com.sample.core.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_user", nullable = false)
    private String userRole;

    @Column(name = "role_description")
    private String roleDescription;


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

}
