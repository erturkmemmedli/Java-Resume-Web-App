package com.erturk;

import com.erturk.service.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailsService")
    private CustomUserDetailsServiceImpl userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/assets/**").permitAll()
                .and().authorizeRequests().antMatchers("/", "index", "/register").permitAll()
                .anyRequest().authenticated().and()
                .formLogin()
                .and().logout();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("erturk@yahoo.com").password("12345").roles("ADMIN")
//                .and().withUser("ayturan@gmail.com").password("54321").roles("USER");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/login**").permitAll()
//            .and()authorizeRequests().antMatchers("/users").hasAnyAuthority("ADMIN")
//            .and().authorizeRequests().antMatchers("/foo").hasAnyAuthority("USER","ADMIN")
//            .and().authorizeRequests().anyRequest().hasAnyAuthority("ADMIN")
//            .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
//            .and().formLogin().loginPage("/login").defaultSuccessUrl("/users").permitAll()
//            .and().logout().logoutSuccessUrl("/login").permitAll()
//            .and().csrf().disable();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().userDetailsService(userDetailsService)
//            .authorizeRequests().antMatchers("/login**").permitAll()
//            .and().authorizeRequests().antMatchers("/users").hasAnyAuthority("ADMIN")
//            .and().authorizeRequests().antMatchers("/index").hasAnyAuthority("USER","ADMIN")
//            .and().authorizeRequests().antMatchers("/register").hasAnyAuthority("USER","ADMIN")
//            .and().authorizeRequests().antMatchers("/foo").hasAnyAuthority("USER","ADMIN")
//            .and().authorizeRequests().anyRequest().hasAnyAuthority("ADMIN")
//            .and().logout().logoutUrl("/users").logoutSuccessUrl("/login")
//            .and().formLogin().loginPage("/login").defaultSuccessUrl("/users").permitAll()
//            .and().logout().logoutSuccessUrl("/login").permitAll();
//
//        return http.build();
//    }
}