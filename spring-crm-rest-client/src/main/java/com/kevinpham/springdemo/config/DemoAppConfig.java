package com.kevinpham.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.kevinpham.springdemo")
@PropertySource({ "classpath:application.properties" })
public class DemoAppConfig implements WebMvcConfigurer {

	// Bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		// Directory for our JSP web pages
		viewResolver.setPrefix("/WEB-INF/view/");
		// Extension of our JSP web pages
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// Bean for RestTemplate (provided by Spring) ...
	// This is used to make client REST calls
	// Injected into the CustomerServiceRestClientImpl class
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// Resource handler for loading css, images, etc in the Deployed
	// Resources/webapp/resources/...
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
