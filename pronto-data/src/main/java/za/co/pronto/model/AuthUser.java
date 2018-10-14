package za.co.pronto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "AUTH_USER")
public class AuthUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_user_id")
    private Long authUserId;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    public AuthUser() {
    }

    public AuthUser(Long authUserId,
                    String username,
                    String password) {
        this.authUserId = authUserId;
        this.username = username;
        this.password = password;
    }

    public Long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(Long authUserId) {
        this.authUserId = authUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUser authUser = (AuthUser) o;
        return Objects.equals(authUserId, authUser.authUserId) &&
                Objects.equals(username, authUser.username) &&
                Objects.equals(password, authUser.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(authUserId, username, password);
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "authUserId=" + authUserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
