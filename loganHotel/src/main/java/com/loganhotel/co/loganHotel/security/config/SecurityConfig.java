package com.loganhotel.co.loganHotel.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Asegúrate de tener esta línea
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authz -> authz
                // Permitir acceso a Swagger UI
                .requestMatchers("/doc/swagger-ui.html/**", 
                               "/swagger-ui/**", 
                               "/v3/api-docs/**").permitAll()
                
                // Configuración para rol RECEPCION
                .requestMatchers("/apihotel/cliente/**").hasRole("RECEPCION")
                .requestMatchers("/apihotel/reserva/**").hasRole("RECEPCION")
                .requestMatchers("/apihotel/habitacion/**").hasAnyRole("RECEPCION", "SERVICIO")
                
                // Configuración para rol SERVICIO
                .requestMatchers("/apihotel/adquiere/**").hasRole("SERVICIO")
                
                // Configuración para rol ADMINISTRACION
                .requestMatchers("/apihotel/empleado/**").hasRole("ADMINISTRACION")
                .requestMatchers("/apihotel/servicio/**").hasRole("ADMINISTRACION")
                
                .anyRequest().authenticated()
            )
            .httpBasic();
        
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        
        // Configura las consultas SQL para usar el esquema hotel
        users.setUsersByUsernameQuery(
            "select username, password, enabled from hotel.users where username = ?");
        users.setAuthoritiesByUsernameQuery(
            "select username, authority from hotel.authorities where username = ?");
        
        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Por ahora usamos NoOpPasswordEncoder para pruebas
        // NO USAR EN PRODUCCIÓN
        return NoOpPasswordEncoder.getInstance();
    }
}