package nl.novi.techiteasy_spring.config;
import nl.novi.techiteasy_spring.filter.JwtRequestFilter;
import nl.novi.techiteasy_spring.service.CustomUserDetailsService;

public class SpringSecurityConfigBuilder {
    private CustomUserDetailsService customUserDetailsService;
    private JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfigBuilder setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
        return this;
    }

    public SpringSecurityConfigBuilder setJwtRequestFilter(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
        return this;
    }

    public SpringSecurityConfig createSpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        return new SpringSecurityConfig(customUserDetailsService, jwtRequestFilter);
    }
}