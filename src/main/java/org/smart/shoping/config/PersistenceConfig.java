package org.smart.shoping.config;

import org.smart.shoping.persistence.services.BusinessService;
import org.smart.shoping.persistence.services.BusinessServiceHandlar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class PersistenceConfig {
	
	@Bean
	public BusinessService getBusinessService()
	{
		return new BusinessServiceHandlar();
	}

}
