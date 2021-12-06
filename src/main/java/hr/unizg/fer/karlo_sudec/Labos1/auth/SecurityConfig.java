package hr.unizg.fer.karlo_sudec.Labos1.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .requiresChannel(channel ->
                    channel.anyRequest().requiresSecure())
                .authorizeRequests().antMatchers("/login", "/css/**", "/webjars/**", "/logout").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login() // enable OAuth2
                .loginPage("/login").defaultSuccessUrl("/")
                .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and()
                .csrf().disable();
    }
}