package com.example.spring_boot_application.config.security;

import com.example.spring_boot_application.constant.ApiConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(ApiConstant.LOGIN, ApiConstant.LOGOUT)
                //~ it is important to permit both /login and /logout api.
                //~ here, nothing to explain to make /login api public. but
                //~ there is a logic to make /logout api public.
                //~ /logout api should be public and it should redirect to /login
                //~ api. the reason is,
                //~ if we try an api e.g. /example then spring security will
                //~ redirect us to /login url. after providing valid username and
                //~ password spring automatically redirect us to /example api.
                //~ if we don't redirect /logout api to /login api just thing
                //~ /logout in the position of /example api. after successful
                //~ login, spring will redirect us to /logout api, which causes
                //~ logout us from application. i.e. spring will logout us
                //~ from application, after successful login.
                .permitAll()
                .antMatchers(ApiConstant.ALL_API_REGEX)
                .hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage(ApiConstant.LOGIN)
                .defaultSuccessUrl(ApiConstant.HOME_API + ApiConstant.SLASH)
                .failureUrl(ApiConstant.LOGIN + "?error=true");
    }
}