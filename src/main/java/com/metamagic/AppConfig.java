package com.metamagic;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * 
 * @author ketangote
 *
 */
@Configuration
@ComponentScan
@EnableWebFlux
public class AppConfig {

	private static final PersistenceManagerFactory PERSISTENCE_MANAGER_FACTORY = JDOHelper.getPersistenceManagerFactory("PersistenceUnit");
	
	
	@Bean
	public PersistenceManagerFactory getPersistenceManagerFactory() {
		return PERSISTENCE_MANAGER_FACTORY;
	}
	
}
