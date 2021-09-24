/*
 * package com.raftel.userservice;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Bean public UserDetailsService mongoUserDetails() { return new
 * CustomUserDetailsService(); }
 * 
 * @Bean public PasswordEncoder getPasswordEncoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { UserDetailsService userDetailsService = mongoUserDetails(); auth
 * .userDetailsService(userDetailsService);
 * 
 * }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .authorizeRequests() .antMatchers("/admin").hasAuthority("ADMIN")
 * .antMatchers("/cus").hasAnyAuthority("CUS")
 * .antMatchers("/").permitAll().anyRequest()
 * .authenticated().and().formLogin().permitAll().and().logout().permitAll(); }
 * }
 */