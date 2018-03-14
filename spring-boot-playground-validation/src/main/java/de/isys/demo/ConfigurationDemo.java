package de.isys.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigurationDemo {

	@Bean
	//@Profile("lower")
	public GreeterService lowerGreeterService() {
		return new GreeterLowercaseImplementation();
	}
//
//	@Bean
//	@Profile("upper")
//	public GreeterService upperGreeterService() {
//		return new GreeterUppercaseImplementation();
//	}

}
