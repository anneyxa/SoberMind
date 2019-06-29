package pl.annurb.model;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class RegisteredUser {
    @NotBlank
    private String login;

    @NotBlank
    private String password;
}
