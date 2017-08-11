package pl.danielpiskorz.futurestaurant.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception{
		http
			.httpBasic().and()
			.authorizeRequests().antMatchers("/restaurants",
					"/owner/restaurant"//TODO required role : OWNER
					).permitAll()
			.and().csrf().disable();//TODO configure csrf protection
	}
}
