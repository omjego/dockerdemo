package com.omjego.dockerdemo.core;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Sample {
    public String message;

    @Override
    public String toString()
    {
        return "{" + message + " " + super.toString() + "}";
    }
}
