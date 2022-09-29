package com.example.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
///import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.filter.JWTFilter;
import com.example.demo.service.FilesStoreService;


//@CrossOrigin("*")
@SpringBootApplication
//@EnableEurekaClient
public class UserManagmentApplication implements CommandLineRunner {

//	@Bean
//	public FilterRegistrationBean jwtFilter()
//	{
//		FilterRegistrationBean fb = new FilterRegistrationBean();
//		fb.setFilter(new JWTFilter());
//		fb.addUrlPatterns("/auth/user/v1/loginUser/*");
//		return fb;
//	}
	
			 @Bean
			    public FilterRegistrationBean<JWTFilter> jwtFilter()
			    {
			        FilterRegistrationBean<JWTFilter> fb = new FilterRegistrationBean<JWTFilter>();
			        fb.setFilter(new JWTFilter());
			        fb.addUrlPatterns("/auth/user/v1//loginUser");
			        return fb;
			    }
	
	
	 @Resource
	  FilesStoreService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(UserManagmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
		
	}

}
