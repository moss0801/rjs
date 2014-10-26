package com.moss.rjs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * RootConext 설정 파일
 * @author moss
 *
 */
@ComponentScan(
		basePackages="com.moss",
		useDefaultFilters=false,
		includeFilters=@ComponentScan.Filter({Service.class, Repository.class}))
@Configuration
public class RootContextConfig {

}
