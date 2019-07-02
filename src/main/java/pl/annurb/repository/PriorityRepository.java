package pl.annurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.annurb.entity.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
