package com.example.karnika.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/v1/*")).build().apiInfo(new ApiInfo("Banking Api","Online Banking Api","1.0","http://localhost:8050/h2-console",new Contact("name","url","karnikathilagar001@gmail.com"),"opensource","http://aihshew-e-mentoring.rf.gd",Collections.emptyList()));
	}
}
