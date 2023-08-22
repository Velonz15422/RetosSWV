package co.edu.udem.isv.ejemplorest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/greeting")
    public String sayHi() {
        return "Hi";
    }

    @GetMapping("/greeting/{name}")
    public String sayHiToMe(@PathVariable String name) {
        return "Hi " + name;
    }
}
