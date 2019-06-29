package pl.annurb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.annurb.entity.Project;
import pl.annurb.entity.User;
import pl.annurb.service.ActivityService;
import pl.annurb.service.ProjectService;
import pl.annurb.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;

    @Autowired
    public ProjectController(UserService userService, ProjectService projectService){
        this.userService = userService;
        this.projectService = projectService;
    }

    @ModelAttribute("projects")
    public List<Project> getProjects(){
        return projectService.getAllProjects();
    }

    @ModelAttribute("users")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/projects")
    public String showProjects(){
        return "projects-list";
    }

    @GetMapping("/see-project/{id}")
    public String showProjectDetails(@PathVariable String id, Model model){

        model.addAttribute("project", projectService.findProjectById(id));
        return "project-details";
    }

    @GetMapping("/add-project")
    public String showAddForm(Model model){
        model.addAttribute("project", new Project());
        return "project-form";
    }

    @PostMapping("/add-project")
    public String addProject(@Valid Project project, BindingResult result, @SessionAttribute(name = "loggedUser", required = false) User loggedUser){
        if(loggedUser == null){
            return "redirect:/sign-up";
        }
        if(!result.hasErrors()){
            projectService.createProject(project, loggedUser);
            return "redirect:/";
        }
        return "redirect:add-project";
    }

    @GetMapping("/edit-project")
    public String showEditForm(@RequestParam(required = false) String id, Model model){
        Project project = projectService.findProjectById(id);
        model.addAttribute("project", project);
        return "project-form";
    }

    @PostMapping("/edit-project")
    public String editProject(@Valid Project project, BindingResult result, @SessionAttribute(name = "loggedUser", required = false) User loggedUser){
        if(loggedUser == null){
            return "redirect:/sign-up";
        }
        if(!result.hasErrors()){
            projectService.editProject(project, loggedUser);
            return "redirect:/";
        }
        return "redirect:edit-project";
    }

    @GetMapping("/delete-project")
    public String showDeleteForm(@RequestParam String id, Model model){
        model.addAttribute("project", projectService.findProjectById(id));
        return "project-delete";
    }

    @PostMapping("/delete-project")
    public String deleteProject(@ModelAttribute Project project, @SessionAttribute(name = "loggedUser", required = false) User loggedUser){
        if(loggedUser == null){
            return "redirect:/sign-up";
        }
        projectService.deleteProject(project, loggedUser);
        return "redirect:/";
    }
}