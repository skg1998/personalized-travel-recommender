package com.personalized_travel_recommender.api.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
    public Docket productApi() {
      return new Docket(DocumentationType.SWAGGER_2)
    		  .apiInfo(apiInfo())
    		  .securityContexts(Arrays.asList(securityContext()))
    	      .securitySchemes(Arrays.asList(apiKey()))
    		  .select()
    		  .apis(RequestHandlerSelectors.basePackage("com.personalized_travel_recommender.api"))
    		  .build();
    }
	
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "PTR api",
	      "Api for personalized travel recommender application",
	      "1.0",
	      "Terms of service",
	      "",
	      "", 
	      toString());
	}
	
	private ApiKey apiKey() { 
	    return new ApiKey("JWT", "Authorization", "header"); 
	}
	
	private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 
	
	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}
}
