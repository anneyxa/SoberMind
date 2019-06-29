package pl.annurb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.annurb.entity.Project;
import pl.annurb.entity.Task;
import pl.annurb.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTask(Task task){
        taskRepository.delete(task);
    }

}
