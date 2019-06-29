package pl.annurb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.annurb.entity.User;
import pl.annurb.model.RegisteredUser;
import pl.annurb.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping("/login")
    public String showLoginForm(Model model, HttpSession session){

        if(session.getAttribute("loggedUser")!=null){
            return "redirect:/";
        }
        model.addAttribute("registeredUser", new RegisteredUser());
        return "log-in";
    }

    @PostMapping("/login")
    public String login(@Valid RegisteredUser registeredUser, BindingResult result, Model model, HttpServletRequest request){

        if(result.hasErrors()){
            return "log-in";
        }

        User user = loginService.login(registeredUser.getLogin(),registeredUser.getPassword());
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", user);
            return "redirect:/";
        }else{
            model.addAttribute("registeredUser", new RegisteredUser());
            model.addAttribute("error", "Invalid login or password");
            return "log-in";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loggedUser");
        return "redirect:/login";
    }
}