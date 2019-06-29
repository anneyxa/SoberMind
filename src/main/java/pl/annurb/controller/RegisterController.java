package pl.annurb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.annurb.entity.User;
import pl.annurb.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/signup")
    public String signUp(@Valid User user, BindingResult result, Model model){
        if(!result.hasErrors()){
            if(userService.createUser(user)){
                return "redirect:/login";
            }else{
                model.addAttribute("user", user);
                model.addAttribute("error", "Unable to create user.");
                return "redirect:signup";
            }
        }
        return "redirect:signup";
    }
}
