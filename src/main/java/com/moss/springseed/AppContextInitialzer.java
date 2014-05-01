package com.moss.springseed;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * App 초기화 파일
 * 1. logging 설정
 * 2. property 로드
 * @see http://spring.io/blog/2011/02/15/spring-3-1-m1-unified-property-management/
 * @author Administrator
 */
public class AppContextInitialzer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	private static Logger log = LoggerFactory.getLogger(AppContextInitialzer.class);
	
	// 로드할 properties 목록
	private static String[] propertyPaths = {"classpath:config/app.properties"};

	@Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
		// Property 로드
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		for (String propertyPath : propertyPaths) {
			try {
				EncodedResource property = new EncodedResource(new DefaultResourceLoader().getResource(propertyPath), "UTF-8");
	            environment.getPropertySources().addFirst(new ResourcePropertySource(property));
	            log.info("=== " + propertyPath + " loaded.");
	        } catch (IOException e) {
	        	log.error("=== fail to load " + propertyPath + ".", e);
	        }
		}
    }
}
