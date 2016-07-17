package org.smart.shoping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/externallib/**", "/smartshopping/**", "/", "/signup","/rest/signup/**","/rest/item/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
                //.failureUrl("/login?error")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and().csrf().disable();
    }

    /*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("tom").password("pass").roles("USER");
	}*/
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            /*auth.ldapAuthentication().userDnPatterns("uid={0},ou=people")
					.groupSearchBase("ou=groups").contextSource()
					.ldif("classpath:test-server.ldif");*/

 /* LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldapAuthenticationProviderConfigurer = auth.ldapAuthentication();

            ldapAuthenticationProviderConfigurer
                //.userSearchFilter("cn={0}")
                //.userSearchBase("ou=people,dc=local")
            .userDnPatterns("uid={0},ou=people,dc=local")
            .groupSearchBase("ou=groups,dc=local")
                .contextSource(contextSource());
             */
        }
        /*
		@Bean
		public DefaultSpringSecurityContextSource contextSource() throws Exception 
		{
			DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource("ldap://192.168.1.60:389");
            contextSource.setUserDn("cn=admin,dc=local");
            contextSource.setPassword("admin");
            contextSource.setReferral("follow"); 
            contextSource.afterPropertiesSet();
            
            return contextSource;
		}
		
		@Bean
	    public LdapTemplate ldapTemplate() throws Exception {
	        return new LdapTemplate(contextSource());        
	    }*/
    }
}
