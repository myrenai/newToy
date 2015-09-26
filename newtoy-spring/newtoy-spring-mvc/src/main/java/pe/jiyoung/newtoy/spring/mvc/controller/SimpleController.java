package pe.jiyoung.newtoy.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
    @RequestMapping(value="/simple", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String simple() {
        return "Hello world!";
    }
}
