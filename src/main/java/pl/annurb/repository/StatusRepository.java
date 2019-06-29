package pl.annurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.annurb.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
