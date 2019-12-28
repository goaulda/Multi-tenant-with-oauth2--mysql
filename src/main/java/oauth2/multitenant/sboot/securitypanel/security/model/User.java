package oauth2.multitenant.sboot.securitypanel.security.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sun.awt.geom.AreaOp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Table(name = "user")
@Entity
public class User implements UserDetails{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "account_expired")
    @NotNull
    private boolean accountExpired;

    @Column(name = "account_locked")
    @NotNull
    private boolean accountLocked;

    @Column(name = "credentials_expired")
    @NotNull
    private boolean credentialsExpired;

    @Column(name = "enabled")
    @NotNull
    private boolean enabled;

    @Override
    @JsonIgnore
    @NotNull
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @Override
    @JsonIgnore
    @NotNull
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Override
    @JsonIgnore
    @NotNull
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @OrderBy
    @JsonFormat
    private Collection<Authority> roles;

    /*
    //Empty Constructor
    */

    public User() {}

    /*
    Getter and Setter
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Authority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Authority> roles) {
        this.roles = roles;
    }
}

