package vn.ute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig {
	
	@Bean
	// authentication
	public UserDetailsService userDetailsService (PasswordEncoder encoder)
	UserDetails admin = User.withUsername("").password(encoder.encode("123")).roles("ADMIN")
	.build();
	UserDetails user = User.withUsername("user")
	.password(encoder.encode("123"))
	.roles("USER")
	.build();
	return new InMemoryUserDetailsManager(admin, user);

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
				auth -> auth.requestMatchers("/").permitAll().requestMatchers("/customer/**").authenticated()
		// .anyRequest().authenticated()
		).formLogin(Customizer.withDefaults()).build();
	}
}
