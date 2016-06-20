package org.smart.shoping.config;

import org.hdiv.config.annotation.EnableHdivWebSecurity;
import org.hdiv.config.annotation.ExclusionRegistry;
import org.hdiv.config.annotation.builders.SecurityConfigBuilder;
import org.hdiv.config.annotation.configuration.HdivWebSecurityConfigurerAdapter;
import org.hdiv.web.multipart.HdivCommonsMultipartResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;

@Configuration
@EnableHdivWebSecurity
public class HdivSecurityConfig extends HdivWebSecurityConfigurerAdapter {
	
	@Override
	public void addExclusions(ExclusionRegistry registry)
	{
		registry.addUrlExclusions("/.*");
	}
	
	@Override
	public void configure(SecurityConfigBuilder builder)
	{
		builder.debugMode(true);
		builder.validateUrlsWithoutParams(false);
		builder.errorPage("/error");
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		/*CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(4000000);
		multipartResolver.setMaxInMemorySize(4000000);
		return multipartResolver;*/
		
		HdivCommonsMultipartResolver resolver = new HdivCommonsMultipartResolver();
		resolver.setMaxUploadSize(4000000);
		resolver.setMaxInMemorySize(4000000);
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}
	
}
