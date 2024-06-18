package com.example.demo;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.dao.AccountDao;
import com.example.demo.entity.Account;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			//.cors((cors) ->cors.
			//configurationSource(corsConfigurationSource()))
			.csrf(csrf -> csrf.ignoringRequestMatchers("/signup"))
			.authorizeHttpRequests(requests -> requests
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.requestMatchers("/signup/**","/login").permitAll()
				.anyRequest().authenticated()
			)
			.userDetailsService(userDetailsServiceImpl)
			
			//ログイン画面へ自動遷移させる
			.formLogin(login -> login
				//.loginProcessingUrl("/login")
				.loginPage("/login")
				.defaultSuccessUrl("/mypage",true)
				//.usernameParameter("email")
				//.passwordParameter("pass")
				.failureUrl("/login?errorpage")
				.permitAll()
			);
			
		return http.build();
	}
	
//	private CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT","DELETE"));
//		
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/signup", configuration);
//		
//		return source;
//	}
	
	
//	@Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//		String userQuery = "select mail,pass,true from users where mail = ?";
//		
//		
//        JdbcUserDetailsManager user = new JdbcUserDetailsManager(this.dataSource);
//        user.setUsersByUsernameQuery(userQuery);
//        user.setDataSource(dataSource);
////        //user.setAuthoritiesByUsernameQuery(userQuery);
////        
////        
//        return user;
//    }
	
}
