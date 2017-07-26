package br.com.rudolfoborges.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author rudolfoborges
 * @since 7/25/17 9:07 PM
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = PersistenceConfig.class)
@EntityScan(basePackageClasses = PersistenceConfig.class)
@EnableTransactionManagement
@PropertySource(ignoreResourceNotFound = false, value = "classpath:persistence-application.properties")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:persistence-application-${spring.profiles.active}.properties")
public class PersistenceConfig {
}
