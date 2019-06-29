package pl.annurb.entity;

import lombok.Data;
import pl.annurb.model.ActivityType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    @Column(nullable = false)
    private ActivityType activityType;

    @OneToOne
    private Project project;

    @OneToOne
    private Task task;

    @Column
    @NotBlank
    private String message;

    @Column
    private LocalDateTime created;

    @Column
    private String site;


    @PrePersist
    public void setMessage(){

        this.created = LocalDateTime.now(Clock.systemUTC());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCreated = this.created.format(formatter);

        switch(activityType){
            case CREATE_PROJECT:
                this.message = String.format("User %s created a new project \"%s\" at %s", user.getLogin(), project.getName(), formattedCreated);
                break;
            case EDIT_PROJECT:
                this.message = String.format("User %s edited existing project \"%s\" at %s", user.getLogin(), project.getName(), formattedCreated);
                break;
            case CREATE_TASK:
                this.message = String.format("User %s created a new task \"%s\" at %s", user.getLogin(), task.getTopic(), formattedCreated);
                break;
            case EDIT_TASK:
                this.message = String.format("User %s edited existing task \"%s\" at %s", user.getLogin(), task.getTopic(), formattedCreated);
                break;
            case DELETE_PROJECT:
                this.message = String.format("User %s deleted a project", user.getLogin(), formattedCreated);
        }
    }
}
