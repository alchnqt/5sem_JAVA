package com.example.lab1.config;

import com.example.lab1.security.MyAuthenticationEntryPoint;
import com.example.lab1.security.jwt.JwtTokenFilter;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenFilter jwtTokenFilter;

    static String USER_ENDPOINT = "/user/**";
    static String ADMIN_ENDPOINT = "/admin/**";

    public SecurityConfig(JwtTokenFilter jwtTokenFilter)
    {
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http = http.cors().and().csrf().disable();

        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();
        http.authorizeRequests()
                .antMatchers("/api/account/login").anonymous()
                .antMatchers("/api/account/register").anonymous()
                .antMatchers("/api/user/**","/api/user").hasAnyRole("ADMIN","USER")
                .antMatchers("/api/admin/**","/api/admin").hasRole("ADMIN")
                .antMatchers("/**","/error","/static","/static/**","/static/**/**").permitAll()
                .anyRequest().authenticated().and()

                .exceptionHandling()
                .authenticationEntryPoint(new MyAuthenticationEntryPoint()).and();



        http.headers()
                .frameOptions()
                .sameOrigin()
                .cacheControl().and();

        http.addFilterBefore(
                jwtTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );
    }
}