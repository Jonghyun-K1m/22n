package com.dnf;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.*;
import com.dnf.service.dnfService;
import com.dnf.service.dnfServiceBeta;
import com.retry.service.BoardService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;



@Configuration
public class dnfSpringConfig {

	private final DataSource dataSource;
	
	
	public dnfSpringConfig(DataSource dataSource) {
	 this.dataSource = dataSource;
	}
	
	@Bean
	public dnfService ddService() {
		return new dnfService(365);		
	}
	@Bean
	public dnfServiceBeta BetaService() {
		return new dnfServiceBeta();		
	}	
}

