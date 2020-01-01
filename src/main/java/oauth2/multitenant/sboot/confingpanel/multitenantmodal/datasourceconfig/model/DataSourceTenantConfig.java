package oauth2.multitenant.sboot.confingpanel.multitenantmodal.datasourceconfig.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "data_source_config")
public class DataSourceTenantConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameTenant;
    private String urlName;
    private String username;
    private String password;
    private String driver;
    private boolean initialize;

    //Constructor

    public DataSourceTenantConfig() {
    }

    //Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTenant() {
        return nameTenant;
    }

    public void setNameTenant(String nameTenant) {
        this.nameTenant = nameTenant;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public boolean isInitialize() {
        return initialize;
    }

    public void setInitialize(boolean initialize) {
        this.initialize = initialize;
    }
}
