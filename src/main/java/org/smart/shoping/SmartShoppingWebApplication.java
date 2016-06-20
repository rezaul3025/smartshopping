package org.smart.shoping;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude={DataSourceTransactionManagerAutoConfiguration.class, MultipartAutoConfiguration.class})
@ComponentScan
public class SmartShoppingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartShoppingWebApplication.class, args);
                
                //AWSECommerceService w = new AWSECommerceService();
	}
}
