package com.moss.rjs;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.moss.rjs.message.MessageMapSource;

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
    
    private Locale[] localeList = new Locale[] {
            Locale.KOREAN,
            Locale.KOREA,
            Locale.US
    };
    
    @Bean
    public MessageMapSource messageMapSource() {
        MessageMapSource messageMapSource = new MessageMapSource();
        messageMapSource.setBasenameList(new String[] {"message/app" });
        messageMapSource.setLocaleList(localeList);
        return messageMapSource;
    }
    
}
