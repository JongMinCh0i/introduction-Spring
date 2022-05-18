package introduction.introductionSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCotroller {

    @GetMapping("/") // localhost:8080
    public String home() {
        return "home";
    }
}
