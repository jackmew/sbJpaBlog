package org.jackho.sbJpaBlog;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    // h2 console
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
    	WebServlet h2Servlet = new WebServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(h2Servlet);
        registration.addUrlMappings("/console/*");
        return registration;
    }
}
