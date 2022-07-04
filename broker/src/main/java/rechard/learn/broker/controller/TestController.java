package rechard.learn.broker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rechard
 **/
@RestController
public class TestController {

    @PostMapping("/test")
    public String test(){
        return "test v1.0.2";
    }
}
