package com.lyscharlie.demo1.commom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/index.php", "/login.php").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				//指定登录页的路径
				.loginPage("/login.php")
				//指定自定义form表单请求的路径
				.loginProcessingUrl("/loginForm.php")
				.failureUrl("/loginError.php")
				.defaultSuccessUrl("/userCenter.php")
				//必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
				//这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
				.permitAll();
		//默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
		http.csrf().disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

}
