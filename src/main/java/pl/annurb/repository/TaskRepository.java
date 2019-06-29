package pl.annurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.annurb.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
