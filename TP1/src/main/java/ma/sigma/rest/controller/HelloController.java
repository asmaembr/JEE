package ma.sigma.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value={"/hello","/"})
    public String hello() {
        System.out.println("ce package sera scané par @SpringBootApplication");
        return "Hello World From my first API @RestController";
    }
}
