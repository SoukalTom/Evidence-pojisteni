package cz.soukal.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("uvodni-stranka")
public class IndexController {

// Renders index page
    @GetMapping
    public String renderIndex() {

        return "index";
    }
}
