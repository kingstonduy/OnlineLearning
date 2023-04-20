package com.dkd.springboot.firstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails userDetails1= createNewUser("dkd", "123");
        UserDetails userDetails2= createNewUser("dkd1", "123");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }
    private UserDetails createNewUser(String username, String password)
    {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails user = User.builder().passwordEncoder(
                        passwordEncoder
                )
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return user;

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()); // make sure all requests are authenticated
        http.formLogin(withDefaults()); // if there is an unauthorized request -> go to form login
        http.csrf().disable(); //
        http.headers().frameOptions().disable();
        // x-frame-option is enable <=> frames can not be used
        // h2-console uses frames => disable x-frame-option header
        return http.build();
    }
}
