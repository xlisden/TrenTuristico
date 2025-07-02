package com.example.demo.Security;

import com.example.demo.Entity.Usuario;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UsuarioService usuarioService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/zona/**", "/usuario/**").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/estaciones")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        List<Usuario> lista = usuarioService.listaSimple();
        if(lista.size() == 0) {

            UserDetails user1 = User.withUsername("merelyn")
                    .password(passwordEncoder().encode("123"))
                    .roles("USER")
                    .build();

            UserDetails user2 = User.withUsername("admin")
                    .password(passwordEncoder().encode("admin"))
                    .roles("ADMIN")
                    .build();
            return new InMemoryUserDetailsManager(user1, user2);
        }

        List<UserDetails> users = new ArrayList<>();
        for (Usuario usuario : lista) {

            UserDetails user = User.withUsername(usuario.getUsername())
                    .password(usuario.getPassword())
                    .roles("ADMIN")
                    .build();
            users.add(user);
        }

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
    }
}