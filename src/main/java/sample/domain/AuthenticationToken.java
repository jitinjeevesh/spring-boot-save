package sample.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "authentication_token")
public class AuthenticationToken implements Serializable {

    @Id
    @Column(name = "token_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer token_id;

    @Column(name = "token")
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiry_datetime", nullable = false)
    private Date expiryDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    public Integer getToken_id() {
        return token_id;
    }

    public void setToken_id(Integer token_id) {
        this.token_id = token_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDateTime() {
        return expiryDateTime;
    }

    public void setExpiryDateTime(Date expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

}
