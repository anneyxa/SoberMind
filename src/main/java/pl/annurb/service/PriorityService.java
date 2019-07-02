package pl.annurb.service;

import org.springframework.stereotype.Service;
import pl.annurb.entity.Priority;
import pl.annurb.repository.PriorityRepository;

import java.util.List;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<Priority>  getAllPriorities(){
        return priorityRepository.findAll();
    }

    public Priority addPriority(Priority priority){
        return priorityRepository.save(priority);
    }

}
