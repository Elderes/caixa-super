package aps.caixa_super;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CaixaSuperApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixaSuperApplication.class, args);
	}

}
