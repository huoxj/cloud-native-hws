package io.daocloud.greetingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping(value = "/greeting")
    @ResponseBody
    public Message greeting(){
        return new Message();
    }
}
