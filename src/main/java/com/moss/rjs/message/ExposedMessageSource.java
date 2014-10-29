package com.moss.rjs.message;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.context.support.ResourceBundleMessageSource;

public class ExposedMessageSource extends ResourceBundleMessageSource {
    public Set<String> getKeys(String basename, Locale locale) {
        ResourceBundle bundle = getResourceBundle(basename, locale);
        return bundle.keySet();
    }
}
