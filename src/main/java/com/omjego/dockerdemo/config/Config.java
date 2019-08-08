package com.omjego.dockerdemo.config;

import com.omjego.dockerdemo.core.Sample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

//@Configuration
public class Config {
    @Bean("requestScopedBean")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Sample requestScopedBean() {
        return new Sample();
    }
}

