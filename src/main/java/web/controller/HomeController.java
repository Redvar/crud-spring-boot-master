package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserService userService;


    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

}
