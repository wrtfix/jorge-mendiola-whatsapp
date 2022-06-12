package com.xscale.whatsapp.controller;

import com.xscale.whatsapp.domain.Greeting;
import com.xscale.whatsapp.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Jorge Carlos Mendiola
 */
@RestController
public class GreetingController {

    private List<HelloMessage> helloMessageList = new ArrayList<>();

    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        helloMessageList.add(message);
        return new Greeting("Welcome, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
