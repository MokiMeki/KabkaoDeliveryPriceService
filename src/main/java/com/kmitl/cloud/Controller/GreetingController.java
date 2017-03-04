package com.kmitl.cloud.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by snow_ on 04-Mar-17.
 */
@CrossOrigin
@RestController
public class GreetingController {
    @GetMapping(value = "")
    public String greeting(){
        String welcomeMsg = "Welcome to KabkaoDeliveryPriceService!! \n"+
                "You can view service api <a href=/swagger-ui.html>here<a>";
        return welcomeMsg;
    }
}
