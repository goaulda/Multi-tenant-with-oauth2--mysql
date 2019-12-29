package oauth2.multitenant.sboot.resourcepanel.endpoints.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class InfoUser {

    @JsonProperty(value = "username")
    String username;
    @JsonProperty(value = "your_ip")
    String ip;
    @JsonProperty(value = "time")
    String datetime;

    public InfoUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
