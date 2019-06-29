package pl.annurb.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.annurb.entity.Project;
import pl.annurb.entity.User;
import pl.annurb.repository.ProjectRepository;
import pl.annurb.repository.UserRepository;
import pl.annurb.service.ProjectService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectService projectService;
    private final UserRepository userRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository, ProjectService projectService, UserRepository userRepository){
        this.projectRepository = projectRepository;
        this.projectService = projectService;
        this.userRepository = userRepository;
    }

    @ModelAttribute("projects")
    public List<Project> getProjects(){
        return projectRepository.findAllByOrderByCreatedDesc();
    }

    @ModelAttribute("users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/projects")
    public String showProjects(){
        return "projects-list";
    }

    @GetMapping("/add-project")
    public String showAddForm(Model model){
        model.addAttribute("project", new Project());
        return "project-form";
    }

    @PostMapping("/add-project")
    public String addProject(@Valid Project project, BindingResult result){
        if(!result.hasErrors()){
            projectService.createProject(project);
            return "redirect:/";
        }
        return "redirect:add-project";
    }

    @GetMapping("/edit-project")
    public String showEditForm(@RequestParam(required = false) String id, Model model){
        Project project = projectRepository.findById(id).orElse(null);
        model.addAttribute("project", project);
        return "project-form";
    }

    @PostMapping("/edit-project")
    public String editProject(@Valid Project project, BindingResult result){
        if(!result.hasErrors()){
            projectService.editProject(project);
            return "redirect:/";
        }
        return "redirect:edit-project";
    }

    @GetMapping("/delete-project")
    public String showDeleteForm(@RequestParam String id, Model model){
        model.addAttribute("project", projectRepository.findById(id).orElse(null));
        return "project-delete";
    }

    @PostMapping("/delete-project")
    public String deleteProject(@ModelAttribute Project project){
        projectRepository.delete(project);
        return "redirect:/";
    }
}