package br.com.rudolfoborges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.rudolfoborges.config.ApiConfig;

/**
 * Created by rudolfoborges on 26/07/17.
 */
@SpringBootApplication
@Import({ApiConfig.class})
public class AppStarter {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}

}
