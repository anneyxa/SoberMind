package pl.annurb.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "projects")
public class Project {

    @Id
    private String id;

    @Column
    private LocalDateTime created;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Name may not be empty")
    private String name;

    @Column
    private String description;

    @Column
    @NotBlank
    private String site;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "projects_users",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_login"))
    private List<User> users = new ArrayList<>();

    @Column
    private boolean active;

    public void setId() {
        this.id = name.replaceAll("żźćńółęąśŻŹĆĄŚĘŁÓŃ", "").replaceAll("\\s", "-");
    }

    public void setId(String name){
        this.id = name;
    }

    @OneToMany(mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Task> tasks;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        created = LocalDateTime.now(Clock.systemUTC());
    }
}
