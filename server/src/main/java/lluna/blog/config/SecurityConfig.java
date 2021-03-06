package lluna.blog.config;

//import org.mapstruct.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //접근 허용
                .antMatchers("/css/**", "/js/**", "/images/**", "/resources/**", "/h2-console/**", "/signup", "/home,", "/").permitAll()
                //인증필요
                .anyRequest().authenticated()
                .and()
                //iframe 허용
                .headers().
                frameOptions().disable()
                .and()
                //DB 어드민 접속 허용
                .csrf()
                .ignoringAntMatchers("/h2-console/**")
                .and()
                //로그인
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/sing-in")
                .defaultSuccessUrl("/welcome")
                .failureUrl("/login?error")
                .usernameParameter("email")
                .passwordParameter("passwd")
                .permitAll()
                .and()
                //예외처리
//                .exceptionHandling().accessDeniedHandler(MemberAccessDeniedHandler())
//                .and()
//                .rememberMe()
//                .key("jpub")
//                .rememberMeParameter("remember-me")
//                .rememberMeCookieName("jpubcookie")
//                .tokenValiditySeconds(86400) //1day
//                .tokenRepository(rememberMeTokenService()).userDetailsService(myUserService())
//                .and()
                //로그아웃
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserService()).passwordEncoder(bCryptPasswordEncoder());
//    }
//
//    @Bean
//    public FilterRegistrationBean getSpringSecuriyFilterChainBindedToError(
//            @Qualifier("springSecurityFilterChain")Filter springSecurityFilterChain) {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(springSecurityFilterChain);
//        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
//        return registration;
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public MyUserService myUserService() throws Exception {
//        return new MyUserService();
//    }
//
//    @Bean
//    public RememberMeTokenService rememberMeTokenService() throws Exception {
//        return new RememberMeTokenService();
//    }
//
//    @Bean
//    public MemberAccessDeniedHandler memberAccessDeniedHandler() throws Exception {
//        return new MemberAccessDeniedHandler();
//    }
}
