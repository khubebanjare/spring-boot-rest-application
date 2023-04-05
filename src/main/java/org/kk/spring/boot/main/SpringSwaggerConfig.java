package org.kk.spring.boot.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringSwaggerConfig {

	private static final String API_VERSION = "1.0";
	private static final String TITLE = "Sprin Boot Rest Application";
	private static final String DESCRIPTION = "This service provide APIs fro Spring Boot Rest Application";
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).
				apiInfo(apiInfo())
				.select()                                  
		          .apis(RequestHandlerSelectors.any())              
		          .paths(PathSelectors.any())                          
		          .build()
		          .tags(new Tag("Employee Controller", "This controller is used for create, get by id and get all for Employees.")); 
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.version(API_VERSION)
				.build();
	}
}
