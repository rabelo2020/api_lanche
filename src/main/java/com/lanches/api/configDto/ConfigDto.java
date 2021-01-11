package com.lanches.api.configDto;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDto {
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
