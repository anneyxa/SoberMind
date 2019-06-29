package pl.annurb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.annurb.entity.Task;
import pl.annurb.service.TaskService;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ModelAttribute("tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    
}
