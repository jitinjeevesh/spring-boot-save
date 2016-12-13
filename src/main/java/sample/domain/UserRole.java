package sample.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_user")
    private String userRole;

    @Column(name = "role_description")
    private String roleDescriprion;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    public String getUserRole() {
        return userRole;
    }


    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


    public String getRoleDescriprion() {
        return roleDescriprion;
    }


    public void setRoleDescriprion(String roleDescriprion) {
        this.roleDescriprion = roleDescriprion;
    }

}
