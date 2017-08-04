package com.syscall.config;
import java.util.Locale;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


/**
 * Created by harley on 26/05/2017.
 */
@ComponentScan
@EnableAutoConfiguration
@Configuration
public class MVCConf extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("auth/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        
        registry.addRedirectViewController("/documentation/v2/api-docs", "/v2/api-docs").setKeepQueryParams(true);
    	registry.addRedirectViewController("/documentation/swagger-resources/configuration/ui","/swagger-resources/configuration/ui");
    	registry.addRedirectViewController("/documentation/swagger-resources/configuration/security","/swagger-resources/configuration/security");
    	registry.addRedirectViewController("/documentation/swagger-resources", "/swagger-resources");
    	registry.addRedirectViewController("/documentation", "/documentation/swagger-ui.html");
        registry.addRedirectViewController("/documentation/", "/documentation/swagger-ui.html");
    }

    @Bean
    public CookieLocaleResolver  localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        localeResolver.setCookieName("lang");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/documentation/**").addResourceLocations("classpath:/META-INF/resources/");
    }
   
    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/i18n/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
