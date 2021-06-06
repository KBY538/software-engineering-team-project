package com.smu.camping.config.security;

import com.smu.camping.service.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    private final String LOGIN_PAGE_URL = "/login";

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/images/**");
        web.ignoring().antMatchers("/fonts/**");
        web.ignoring().antMatchers("/vendor/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(LOGIN_PAGE_URL, "/main").permitAll() // 로그인 페이지는 모두에게 permit
            //.antMatchers("/").authenticated()
            //.anyRequest().hasRole("COMPANY")
            .and()
                .formLogin()
                    .failureHandler(new AuthFailureHandler())
                    .loginPage(LOGIN_PAGE_URL)
                    .loginProcessingUrl("/authenticate")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/main", true)
                    .permitAll()
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl(LOGIN_PAGE_URL);


        // ! 이 코드가 포함되면, 세션 만료시 AjaxSessionCheckFilter가 있어도 만료된 후, 첫 ajax 요청에는 로그인 페이지로 리다이렉트 응답하고,두번째 ajax 요청을 해야 403 에러로 응답을 해서 주석 처리 함.
        // http.sessionManagement().invalidSessionUrl(LOGIN_PAGE_URL).maximumSessions(1).expiredUrl(LOGIN_PAGE_URL);   // ? https://stackoverflow.com/questions/59173467/how-to-set-spring-security-session-timeout 참조
        /*
            ? https://niees.tistory.com/17 참조
            * invalid-session-url​ : 세션이 끊겼을때 이동 할 페이지
            * max-sessions : 최대 허용 가능 세션 수​
            * expired-url :  중복 로그인이 일어났을 경우 이동 할 주소
         */
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
