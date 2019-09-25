/**
 * 
 */
package com.quest.continents.country.flag.poc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.quest.continents.country.flag.poc.util.annotation.AuditAndMeterInterceptor;

/**
 * @author Moti
 *
 */
@Configuration
public class Config implements WebMvcConfigurer
{
    //@Autowired
    //MinimalInterceptor minimalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new AuditAndMeterInterceptor());
    }
}