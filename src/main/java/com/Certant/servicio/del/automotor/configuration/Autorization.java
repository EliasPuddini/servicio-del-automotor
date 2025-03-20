package com.Certant.servicio.del.automotor.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Autorization {

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(request->

                request
                        .requestMatchers("api/users").authenticated()
                        .requestMatchers("/api/**").permitAll()


        )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService testUser() {
        User.UserBuilder user = User.builder();
        UserDetails user1 = user.username("admin")
                .password(passwordEncoder().encode("abc123"))
                .roles()
                .build();
        return new InMemoryUserDetailsManager(user1);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
