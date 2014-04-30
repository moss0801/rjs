package com.moss.springseed;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * ServletContext 설정 파일
 * @author moss
 *
 */
@EnableWebMvc
@ComponentScan(
		basePackages="com.moss.springseed",
		useDefaultFilters=false,
		includeFilters=@ComponentScan.Filter({Controller.class, RestController.class}))
@Configuration
public class ServletContextConfig {

}
