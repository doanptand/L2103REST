package com.ddona.rest.adapter

import com.ddona.rest.filter.JWTAuthenticationFilter
import com.ddona.rest.filter.JWTLoginFilter
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
class WebSecureConfig : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("doanpt")
            .password("{noop}deptrai")
            .roles("admin")
        auth.inMemoryAuthentication()
            .withUser("l2103")
            .password("{noop}t3h")
            .roles("user")
    }

    override fun configure(http: HttpSecurity) {
        //nơi config xác thực các url:
        //url nào cần xác thức, và url k xác thực
        //nếu cần xác thực thì xác thực ở đâu
        //http://localhost:8888/
        http
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers(HttpMethod.POST, "/register").permitAll()
            .anyRequest().authenticated().and()
            .addFilterBefore(
                JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter::class.java
            ).addFilterBefore(
                JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter::class.java
            )
    }
}