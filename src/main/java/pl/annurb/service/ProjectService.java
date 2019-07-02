package pl.annurb.service;

import org.springframework.stereotype.Service;
import pl.annurb.entity.Activity;
import pl.annurb.entity.Task;
import pl.annurb.model.ActivityType;
import pl.annurb.entity.Project;
import pl.annurb.entity.User;
import pl.annurb.repository.ActivityRepository;
import pl.annurb.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ActivityRepository activityRepository;

    public ProjectService(ProjectRepository projectRepository, ActivityRepository activityRepository) {
        this.projectRepository = projectRepository;
        this.activityRepository = activityRepository;
    }

    //nadawanie id
    public boolean createProject(Project project, User user) {

        if (user != null) {

            if (projectRepository.hasName(project.getName())) {
                return false;

            } else {
                project.setId();
                Project savedProject = projectRepository.save(project);

                Activity activity = new Activity();
                activity.setActivityType(ActivityType.CREATE_PROJECT);
                activity.setProject(project);
                activity.setUser(user);
                activity.setSite("/see-project/" + project.getId());
                activityRepository.save(activity);

                return null != savedProject;
            }
        } else {
            return false;
        }
    }

    public boolean editProject(Project project, User user) {

        if (user != null && projectRepository.hasName(project.getName())) {

            Project savedProject = projectRepository.save(project);

            Activity activity = new Activity();
            activity.setActivityType(ActivityType.EDIT_PROJECT);
            activity.setProject(project);
            activity.setUser(user);
            activity.setSite("/see-project/" + project.getId());
            activityRepository.save(activity);

            return null != savedProject;
        } else {
            return false;
        }
    }

    public List<Project> get5Projects() {
        return projectRepository.findFirst5ByOrderByCreatedDesc();
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAllByOrderByCreatedDesc();
    }

    public Project findProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteProject(Project project, User user) {

        Activity activity = new Activity();
        activity.setActivityType(ActivityType.DELETE_PROJECT);
        activity.setUser(user);
        activityRepository.save(activity);

        projectRepository.delete(project);
    }
}