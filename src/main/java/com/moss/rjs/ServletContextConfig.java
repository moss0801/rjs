package com.moss.rjs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * ServletContext 설정 파일
 * @author moss
 *
 */
@EnableWebMvc
@ComponentScan(
		basePackages="com.moss",
		useDefaultFilters=false,
		includeFilters=@ComponentScan.Filter({Controller.class, RestController.class}))
@Configuration
public class ServletContextConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/app/**").addResourceLocations("/app/");
        registry.addResourceHandler("/dist/**").addResourceLocations("/dist/");
        registry.addResourceHandler("/bower_components/**").addResourceLocations("/bower_components/");
    }
    
    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolve = new ServletContextTemplateResolver();
        templateResolve.setPrefix("app/");
        templateResolve.setSuffix(".html");
        templateResolve.setTemplateMode("HTML5");
        templateResolve.setCacheable(false);
        return templateResolve; 
    }
    
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
    
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCache(false);
        return thymeleafViewResolver;
    }
}
