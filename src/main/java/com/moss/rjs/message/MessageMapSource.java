package com.moss.rjs.message;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.Assert;

public class MessageMapSource implements InitializingBean {
    private Locale[] localeList = new Locale[0];
    private String[] basenameList = new String[0];
    private String defaultEncoding = "UTF-8";
    

    private Map<Locale, Map<String, String>> messageMap = new HashMap<Locale, Map<String, String>>();

    public void setLocaleList(Locale[] localeList) {
        Assert.notNull(localeList);
        this.localeList = localeList;
    }
    
    public void setBasenameList(String[] basenameList) {
        Assert.notNull(basenameList);
        this.basenameList = basenameList;
    }
    
    public void setDefaultEncoding(String defaultEncoding) {
        Assert.notNull(defaultEncoding);
        this.defaultEncoding = defaultEncoding;
    }
    
    public class ExposedMessageSource extends ResourceBundleMessageSource {
        public Set<String> getKeys(String basename, Locale locale) {
            ResourceBundle bundle = getResourceBundle(basename, locale);
            return bundle.keySet();
        }
    }
    
    public Map<String, String> getMessageMap(Locale locale) {
        return messageMap.get(locale);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ExposedMessageSource messageSource = new ExposedMessageSource();
        messageSource.setBasenames(basenameList);
        messageSource.setDefaultEncoding(defaultEncoding);
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
    }

}
