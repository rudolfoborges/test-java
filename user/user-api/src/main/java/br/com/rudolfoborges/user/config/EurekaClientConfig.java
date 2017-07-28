package br.com.rudolfoborges.user.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by rudolfoborges on 28/07/17.
 */
@Profile("!local")
@Configuration
@EnableEurekaClient
public class EurekaClientConfig {
}
