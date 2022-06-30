package com.hyeon.dnf.config;
import com.hyeon.dnf.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class dnfconfig {

	@Bean(name ="call")
	public void PropertiesFactoryBean() {
		
	}
	@Bean
	public dnfService dnfService() {
		return new dnfService();
	}
}
