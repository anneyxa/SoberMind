package pl.annurb.service;

import org.springframework.stereotype.Service;
import pl.annurb.entity.Status;
import pl.annurb.repository.StatusRepository;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatuses(){
        return statusRepository.findAll();
    }

    public Status addStatus(Status status){
        return statusRepository.save(status);
    }

}
