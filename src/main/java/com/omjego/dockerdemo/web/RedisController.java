package com.omjego.dockerdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController
{

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @GetMapping("/count")
    @ResponseBody
    public String getCount() {
        String key = "count";
        return "Visits : " + redisTemplate.opsForValue().increment(key, 1);
    }
}
