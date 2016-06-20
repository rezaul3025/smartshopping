package org.smart.shoping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		String imageUploadPath = env.getProperty("business_image_path");
		registry.addResourceHandler("/static/**").addResourceLocations("file://"+imageUploadPath);
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/login").setViewName("/login");
		registry.addViewController("/signin").setViewName("/signin");
		registry.addViewController("/business/list").setViewName("/business/list");
		/*registry.addViewController("/manual").setViewName("/manual");
		registry.addViewController("/glossary").setViewName("/glossary");
		registry.addViewController("/search").setViewName("/search");
		registry.addViewController("/statisticsIndexPage").setViewName("/statisticsIndexPage");
		registry.addViewController("/test/lucene").setViewName("/luceneTest");
		registry.addViewController("/discuss/glossary").setViewName("/discuss/glossary");
		registry.addViewController("/discuss/ng-pagination").setViewName("/discuss/ng-pagination");
		registry.addViewController("/curation/variant-unique").setViewName("/curation/variantunique/list");
		registry.addViewController("/curation/phenotypes").setViewName("/curation/phenotype/list");
		registry.addViewController("/publicexporter").setViewName("/publicExporter");
		registry.addViewController(RELATED_VARIANTS).setViewName("/relatedVariants");
		registry.addViewController(ERRORS_VIEW_404).setViewName(ERRORS_VIEW_404);
		registry.addViewController(ACCESS_DENIED_VIEW_403).setViewName(ACCESS_DENIED_VIEW_403);
		registry.addViewController(ERRORS_VIEW).setViewName(ERRORS_VIEW);
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);*/
	}

}
