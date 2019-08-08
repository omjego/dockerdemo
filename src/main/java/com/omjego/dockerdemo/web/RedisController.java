package com.omjego.dockerdemo.web;

import com.omjego.dockerdemo.core.Sample;
import com.omjego.dockerdemo.core.SomeRandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.inject.Provider;

@Controller
public class RedisController
{

    @Autowired
    private Provider<Sample> provider;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    SomeRandomService someRandomService;


    @GetMapping("/count")
    @ResponseBody
    public String getCount() {

        Sample sample = provider.get();
        System.out.println("Previous message: " + sample.message);
        sample.message = "Hello There : " + Thread.currentThread().getName();
        System.out.println("New Message: " + sample.message);
        someRandomService.willTryToAccess();

        String key = "count";
//        return "Visits : " + redisTemplate.opsForValue().increment(key, 1);
        return key ;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String defaultMethod() {
        return  "Hi there";
    }
}
