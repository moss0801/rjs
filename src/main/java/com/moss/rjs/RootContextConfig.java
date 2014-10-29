package com.moss.rjs;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.moss.rjs.message.ExposedMessageSource;
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
            Locale.KOREA
    };
    
    @Bean
    public ExposedMessageSource messageSource() {
        ExposedMessageSource  messageSource = new ExposedMessageSource ();
        messageSource.setBasenames("message/app");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    /*@Bean
    public Map<Locale, Map<String, String>> messageMap() {
        Map<Locale, Map<String, String>> messageMap = new HashMap<Locale, Map<String, String>>();
        String[] basenameList = new String[] { "message/app" };
        ExposedMessageSource messageSource = messageSource();
        for (Locale locale : localeList) {
            Map<String, String> localeMessageMap = new HashMap<String, String>();
            for (String basename : basenameList) {
                Set<String> keys = messageSource.getKeys(basename, locale);
                for (String key : keys) {
                    localeMessageMap.put(key, messageSource.getMessage(key, null, locale));
                }
            }
            messageMap.put(locale, localeMessageMap);
        }
        return messageMap;
    }*/
    
    @Bean
    public MessageMapSource messageMapSource() {
        MessageMapSource messageMapSource = new MessageMapSource();
        messageMapSource.setBasenameList(new String[] {"message/app" });
        messageMapSource.setLocaleList(localeList);
        return messageMapSource;
    }
    
}
