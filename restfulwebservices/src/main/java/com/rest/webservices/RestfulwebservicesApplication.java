package com.rest.webservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestfulwebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulwebservicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
	   AcceptHeaderLocaleResolver sessionLocaleResolver = new AcceptHeaderLocaleResolver();
	   sessionLocaleResolver.setDefaultLocale(Locale.US);
	   return sessionLocaleResolver;
	}
	
	  /*@Bean
	   public ResourceBundleMessageSource bundleMessageSource() {
	      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	      messageSource.setBasename("messages");
	      return messageSource;
	   }*/
}
