package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MuzixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);

	}

//		@Bean
//		ServletRegistrationBean h2servletRegistration(){
//			ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
//			registrationBean.addUrlMappings("/console/*");
//			return registrationBean;
//		}



}

