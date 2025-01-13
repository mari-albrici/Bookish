package bookish.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {

    @Id
    private UUID id;

    private String username;

    private String email;
    private String password;
    private String bio;
    private Date createdAt;
    private Date updatedAt;

 
}
