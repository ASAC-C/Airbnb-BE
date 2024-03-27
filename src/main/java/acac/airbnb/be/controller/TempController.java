package acac.airbnb.be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {
    @GetMapping("/hello")
    public String helloPage(){
        return "hello";
    }
}
