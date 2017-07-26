package br.com.rudolfoborges.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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

}
