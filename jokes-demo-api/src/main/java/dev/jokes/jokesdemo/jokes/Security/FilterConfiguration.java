package dev.jokes.jokesdemo.jokes.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class FilterConfiguration {

    @Bean
    @Order(1)
    public SecurityFilterChain defaultChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/jokes/public/**").permitAll()
                        .requestMatchers("/api/jokes/secure/**").authenticated()
                )
                .cors(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }

//    @Bean
//    @Order(2)
//    public SecurityFilterChain loggedSecurityChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .cors(Customizer.withDefaults())
//                .authorizeHttpRequests(auth->auth.requestMatchers(""))
//    }
}
