package pl.annurb.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false) //TODO: haszowanie przy tworzeniu hasła
    private String surname;

    @NotBlank
    @Column(nullable = false)
    private String password;

    public String getFullName() {
        return String.format("%s %s", name, surname);
    }

}
