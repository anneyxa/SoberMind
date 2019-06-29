package pl.annurb.service;

import org.springframework.stereotype.Service;
import pl.annurb.entity.Project;
import pl.annurb.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    //nadawanie id
    public boolean createProject(Project project){
        if(projectRepository.hasName(project.getName())){
            return false;
        }else{
            project.setId();
            return null != projectRepository.save(project);
        }
    }

    public boolean editProject(Project project){
        return null != projectRepository.save(project);
    }

    public List<Project> get5Projects(){
        return projectRepository.findFirst5ByOrderByCreatedDesc();
    }
}