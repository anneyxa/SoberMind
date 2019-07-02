package pl.annurb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.annurb.entity.*;
import pl.annurb.service.PriorityService;
import pl.annurb.service.ProjectService;
import pl.annurb.service.StatusService;
import pl.annurb.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final StatusService statusService;
    private final PriorityService priorityService;

    @Autowired
    public TaskController(TaskService taskService, ProjectService projectService, StatusService statusService, PriorityService priorityService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.statusService = statusService;
        this.priorityService = priorityService;
    }

    @ModelAttribute("tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @ModelAttribute("projects")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @ModelAttribute("statuses")
    public List<Status> getAllStatuses(){
        return statusService.getAllStatuses();
    }

    @ModelAttribute("priorities")
    public List<Priority> getAllPriorities(){
        return priorityService.getAllPriorities();
    }

    @GetMapping("/tasks")
    public String seeAllTasks(){
        return "tasks-list";
    }

    @GetMapping("/see-task/{id}")
    public String seeTaskDetails(@PathVariable Long id, Model model){
        model.addAttribute("task", taskService.findTaskById(id));
        return "task-details";
    }

    @GetMapping("/add-task")
    public String showTaskForm(Model model){
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/add-task")
    public String addTask(@Valid Task task, BindingResult result, @SessionAttribute("loggedUser") User user){
        if(!result.hasErrors()){
            taskService.createTask(task, user);
            return "redirect:/tasks";
        }
        return "redirect:/add-task";
    }
}