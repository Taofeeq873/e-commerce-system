package com.ecommerce.codeshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   /* @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }*/

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")


                .antMatchers("/anonymous*").anonymous()

                .antMatchers("/category/**").permitAll()
                .antMatchers("/categories").permitAll()
                .antMatchers("/categories/**").permitAll()
                .antMatchers("/category/sub/**").permitAll()
                .antMatchers("/category/delete/**").permitAll()

                .antMatchers("/product/**").permitAll()
                .antMatchers("/products").permitAll()
                .antMatchers("/products/category/**").permitAll()
                .antMatchers("/product/delete/**").permitAll()

                .antMatchers("/customer/**").permitAll()
                .antMatchers("/customerPage/**").permitAll()
                .antMatchers("/customer/delete/**").permitAll()
                .antMatchers("/customers").permitAll()

                .antMatchers("/search/**").permitAll()

                .antMatchers("/uploads/**").permitAll()


                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                //.loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/login", true)
                //.failureUrl("/login.html?error=true")
                //.failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                //.logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID");
                //.logoutSuccessHandler(logoutSuccessHandler());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/static/**", "/css/**", "/js/**", "/images/**", "/icons/**","/plugins/**", "/fonts/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
