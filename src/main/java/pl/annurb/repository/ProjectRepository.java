package pl.annurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.annurb.entity.Project;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    Optional<Project> findByName(String name);

    default boolean hasName(String name){
        return findByName(name).isPresent();
    }

    List<Project> findFirst5ByOrderByCreatedDesc();
    List<Project> findAllByOrderByCreatedDesc();
}