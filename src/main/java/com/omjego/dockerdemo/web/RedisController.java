package com.omjego.dockerdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;

@Controller
public class RedisController
{
    private static final String[] messages = {"random", "dranom", "dramon",
            "ndarom", "omradn"};


    @GetMapping("/hello")
    @ResponseBody
    public String defaultMethod()
    {
        String name = messages[getStreamOfRandomIntsWithRange(0, messages.length -1 )];
        return  "<h1>Hi  :" + name + "<h1>";
    }

    public static int getStreamOfRandomIntsWithRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max);
   }


    /**
     * chosen by fair dice roll, guaranteed to be random.
     * @return random number
     */
   public static int getRandomNumber() {
        return 3;
   }

}
