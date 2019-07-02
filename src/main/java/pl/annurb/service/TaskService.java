package pl.annurb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.annurb.entity.Activity;
import pl.annurb.entity.Task;
import pl.annurb.entity.User;
import pl.annurb.model.ActivityType;
import pl.annurb.repository.ActivityRepository;
import pl.annurb.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ActivityRepository activityRepository;

    public TaskService(TaskRepository taskRepository, ActivityRepository activityRepository) {
        this.taskRepository = taskRepository;
        this.activityRepository = activityRepository;
    }

    public Task createTask(Task task, User user){

        Task createdTask = taskRepository.save(task);

        Activity activity = new Activity();
        activity.setUser(user);
        activity.setTask(task);
        activity.setActivityType(ActivityType.CREATE_TASK);
        activity.setSite("/see-task/" + task.getId());
        activityRepository.save(activity);

        return createdTask;
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
