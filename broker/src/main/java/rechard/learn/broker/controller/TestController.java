package rechard.learn.broker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rechard
 **/
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test v1.1.3";
    }
}
