package co.edu.udem.isv.ejemplorest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/greetingByRequestParam")
    public String sayHiByRequestParam(@RequestParam String name) {
        return "Hi " + name;
    }

    @PostMapping("/greetingByRequestBody")
    public String sayHiByRequestBody(@RequestBody Person person) {
        return "Hi " + person.getFirstName() + " " + person.getLastName();
    }
}
