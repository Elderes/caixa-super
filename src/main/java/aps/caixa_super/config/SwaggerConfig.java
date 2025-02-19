package aps.caixa_super.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API CaixaSuper")
                        .version("1.0")
                        .description("CaixaSuper"));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**").permitAll() // Allow Swagger
                .requestMatchers("/gerente/**").authenticated() // Protect manager endpoints
                .anyRequest().permitAll()
            )
            .httpBasic(withDefaults()) // Enable Basic Authentication
            .formLogin(withDefaults()); // Enable Form-based Authentication

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(
            @Value("${spring.security.user.name}") String username,
            @Value("${spring.security.user.password}") String password) {

        UserDetails user = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("MANAGER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}