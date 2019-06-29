package pl.annurb.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime created;

    @Column(nullable = false)
    private String topic;

    @ManyToOne
    private Project project;

    @Column
    private String description;

    @OneToOne
    private Status status;

    @OneToOne
    private Priority priority;

    @ManyToOne
    private User user;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now(Clock.systemUTC());
    }

}
