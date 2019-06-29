package pl.annurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.annurb.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
