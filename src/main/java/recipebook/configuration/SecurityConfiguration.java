package recipebook.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/api/**")
            .authorizeHttpRequests((auth) -> auth
                .requestMatchers(HttpMethod.POST, "/api/feature/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/api/feature/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/api/feature/**").authenticated()
                .anyRequest().permitAll()
            )
            .oauth2ResourceServer((oauth2) -> oauth2
                .jwt(withDefaults())
            );

        return http.build();
    }

}