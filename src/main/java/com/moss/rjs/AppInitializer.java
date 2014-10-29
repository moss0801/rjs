package com.moss.rjs;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Application 설정 파일 (기존 web.xml 대체)
 * @author moss
 * @see http://www.java-allandsundry.com/2012/05/spring-webapplicationinitializer-and.html
 */
public class AppInitializer implements WebApplicationInitializer {

	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
		// AppContextInitializer
		servletContext.setInitParameter("contextInitializerClasses", AppContextInitialzer.class.getName());
		
		// Filter
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic cef = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        cef.addMappingForUrlPatterns(null, false, "/*");
        
		// Root Context
        servletContext.addListener(new ContextLoaderListener(getRootContext()));
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("servlet", new DispatcherServlet(getServletContext()));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }

    private AnnotationConfigWebApplicationContext getRootContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(RootContextConfig.class.getName());
        return context;
    }
    
    private AnnotationConfigWebApplicationContext getServletContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(ServletContextConfig.class.getName());
        return context;
    }
}
