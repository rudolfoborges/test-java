package br.com.rudolfoborges.user;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import br.com.rudolfoborges.user.persistence.PersistenceConfig;


/**
 * Created by rudolfoborges on 26/07/17.
 */
@Configuration
@EnableCircuitBreaker
@EnableHystrixDashboard
@Import({PersistenceConfig.class})
@ComponentScan(basePackageClasses = {CoreConfig.class})
@PropertySource(ignoreResourceNotFound = false, value = "classpath:core-application.properties")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:core-application-${spring.profiles.active}.properties")
public class CoreConfig {
}
