package pl.annurb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.annurb.entity.User;
import pl.annurb.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/users")
    public String seeAllUsers(){
        return "users-list";
    }

    @GetMapping("/see-user/{id}")
    public String seeUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "user-details";
    }

    @GetMapping("/edit-account/{id}")
    public String showEditAccountForm(@PathVariable Long id, Model model, @SessionAttribute(name = "loggedUser", required = false) User loggedUser){
        if(loggedUser == null){
            return "redirect:/sign-up";
        }
        User actualUser = userService.findUserById(id);
        model.addAttribute("user", actualUser);
        model.addAttribute("loggedUser", loggedUser);

        return "user-edit";
    }

    @PostMapping("/edit-account/{id}")
    public String editAccount(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        if(userService.editUser(user)){
            return "redirect:/see-user/"+user.getId();
        }
        return "redirect:/";
    }



}
