package pl.annurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.annurb.entity.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findFirst25ByOrderByCreatedDesc();
}
