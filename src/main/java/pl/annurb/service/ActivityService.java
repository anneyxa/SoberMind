package pl.annurb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.annurb.entity.Activity;
import pl.annurb.repository.ActivityRepository;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getLast25Activities(){
        return activityRepository.findFirst25ByOrderByCreatedDesc();
    }

}
