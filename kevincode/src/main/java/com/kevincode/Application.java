package com.kevincode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * User: kevin.xie<br/>
 * Date: 29/03/2020<br/>
 * Time: 15:37<br/>
 */
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    @Description("Thymeleaf template Resolver")
//    public ServletContextTemplateResolver templateResolver(ServletContext servletContext) {
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
//        templateResolver.setPrefix("/templates");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML");
//
//        return templateResolver;
//    }

//    @Bean
//    @Description("Thymeleaf Template Engine")
//    public SpringTemplateEngine templateEngine(ServletContextTemplateResolver templateResolver) {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        templateEngine.setTemplateEngineMessageSource(messageSource());
//        return templateEngine;
//    }
//
//    @Bean
//    @Description("Thymeleaf View Resolver")
//    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(templateEngine);
//        thymeleafViewResolver.setOrder(1);
//        return thymeleafViewResolver;
//    }

    @Bean
    @Description("Spring Message Resolver")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

}
