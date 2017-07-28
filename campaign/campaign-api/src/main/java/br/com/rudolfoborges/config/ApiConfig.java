package br.com.rudolfoborges.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import br.com.rudolfoborges.core.CoreConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by rudolfoborges on 26/07/17.
 */
@Configuration
@ComponentScan({"br.com.rudolfoborges"})
@Import({CoreConfig.class})
@PropertySource(ignoreResourceNotFound = false, value = "classpath:api-application.properties")
public class ApiConfig {

	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return mapper;
	}

}
