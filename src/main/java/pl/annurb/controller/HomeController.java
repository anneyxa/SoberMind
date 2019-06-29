package pl.annurb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.annurb.entity.Activity;
import pl.annurb.entity.Project;
import pl.annurb.service.ActivityService;
import pl.annurb.service.ProjectService;

import java.util.List;

// TODO: wzorzec observer

@Controller
public class HomeController {

    private final ProjectService projectService;
    private final ActivityService activityService;

    public HomeController(ProjectService projectService, ActivityService activityService){
        this.projectService = projectService;
        this.activityService = activityService;
    }

    @ModelAttribute("projects")
    public List<Project> lastProjects(){
        return projectService.get5Projects();
    }

    @ModelAttribute("activities")
    public List<Activity> lastActivities(){
        return activityService.getLast25Activities();
    }

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

}