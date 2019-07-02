package pl.annurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.annurb.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
