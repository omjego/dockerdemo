package com.omjego.dockerdemo.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;

@Service
public class SomeRandomService
{
    @Autowired
    private Provider<Sample> provider;

    public void willTryToAccess() {
        Sample sample = provider.get();
        System.out.println("From random service : " + sample);
    }
}
