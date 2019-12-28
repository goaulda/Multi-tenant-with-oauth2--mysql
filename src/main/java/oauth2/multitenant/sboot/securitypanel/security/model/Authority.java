package oauth2.multitenant.sboot.securitypanel.security.model;

import com.sun.xml.internal.ws.developer.Serialization;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "role")
@Serialization
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Authority() {
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
