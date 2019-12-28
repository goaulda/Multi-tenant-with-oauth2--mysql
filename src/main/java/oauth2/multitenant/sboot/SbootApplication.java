package oauth2.multitenant.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootApplication.class, args);
	}

}
