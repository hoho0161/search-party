package com.ApexParty.searchparty.config.auth;

import com.ApexParty.searchparty.domain.users.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()))
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers(new AntPathRequestMatcher("/"),
                                        new AntPathRequestMatcher("/img/**"),
                                        new AntPathRequestMatcher("/css/**"),
                                        new AntPathRequestMatcher("/js/**"),
                                        new AntPathRequestMatcher("/h2-console/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/api/v1/**")).hasRole(Role.USER.name())
                                .anyRequest().authenticated())
                .logout((logout) -> logout.logoutSuccessUrl("/"))
                .oauth2Login((oauth2Login)->oauth2Login.userInfoEndpoint((userInfoEndpoint)->userInfoEndpoint.userService(customOAuth2UserService)));
        return http.build();
    }
}
