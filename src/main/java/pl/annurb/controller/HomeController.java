package pl.annurb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.annurb.entity.Project;
import pl.annurb.service.ProjectService;

import java.util.List;

// TODO: wzorzec observer

@Controller
public class HomeController {

    private final ProjectService projectService;

    public HomeController(ProjectService projectService){
        this.projectService = projectService;
    }

    @ModelAttribute("projects")
    public List<Project> lastProjects(){
        return projectService.get5Projects();
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

}