package com.project.thrifting.security;

import com.project.thrifting.security.jwt.AuthEntryPointJwt;
import com.project.thrifting.security.jwt.AuthTokenFilter;
import com.project.thrifting.security.services.UserDetailServiceImpl;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {

        return new AuthTokenFilter();

    }

    /**
     * Spring Security will load User details to perform authentication &
     * authorization. So it has UserDetailsService interface that we need to
     * implement.
     *
     * – The implementation of UserDetailsService will be used for configuring
     * DaoAuthenticationProvider by
     * AuthenticationManagerBuilder.userDetailsService() method.
     *
     * – We also need a PasswordEncoder for the DaoAuthenticationProvider. If we
     * don’t specify, it will use plain text.
     *
     *
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(passwordEncoder());

    }
//    String[] resources = new String[]{
//        "/", "/home", "/pictureCheckCode", "/include/**",
//        "/css/**", "/icons/**","/public/**","resources/**", "/images/**","/images2/**", "/js/**", "/layer/**"
//    };

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                //                .antMatchers(resources).permitAll()           
                .antMatchers("/welcome/**").permitAll()
                //                .antMatchers("/api/test/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList(""));
//        configuration.setAllowedMethods(Arrays.asList(""));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

}
