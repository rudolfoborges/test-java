package br.com.rudolfoborges.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rudolfoborges
 * @since 7/26/17 12:41 PM
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket endpoints() {
        return new Docket(DocumentationType.SWAGGER_2)//
                .select()//
                .paths(PathSelectors.regex("(/v1/campaigns|/v1/campaigns.*)"))//
                .build()
                .apiInfo(new ApiInfoBuilder().title("Campaign API")
                        .description("API para criação e gerenciamento de campanhas")
                        .build());
    }

}
