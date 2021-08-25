package com.natwest.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	@Bean
	public Docket getdocketbean() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.natwest.client")).build().apiInfo(setmyapiinfo())
				.useDefaultResponseMessages(false);

	}

	public ApiInfo setmyapiinfo() {

		ApiInfoBuilder apibuild = new ApiInfoBuilder();

		apibuild.title("Client Microservice").license("vaibhavk@natwest.in")
				.description("APi to interact with Mongo and provides CRUD ops").version("V1.1");

		return apibuild.build();

	}
}
