package com.mcpayment.payx.api.jwt;

import com.mcpayment.payx.api.handler.AuthFilter;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * User: kevin.xie<br/>
 * Date: 13/10/2020<br/>
 * Time: 16:20<br/>
 */
@EnableWebSecurity
public class JwtAuthConfig extends WebSecurityConfigurerAdapter {

    public ConfigurableJWTProcessor<SecurityContext> processor;

    @Autowired
    AuthFilter authFilter;

    public JwtAuthConfig(ConfigurableJWTProcessor<SecurityContext> processor) {
        this.processor = processor;
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/health").permitAll()
                .antMatchers("/api/auth/oauth2/token").permitAll()
                .antMatchers("/api/user/get-auth-version").permitAll()
                .anyRequest().permitAll()
                .and()
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
