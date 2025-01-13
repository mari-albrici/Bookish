package bookish.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    private UUID id;

    private String bookISBN;

    private UUID userId;

    private String content;
    private Date createdAt;
    private Date updatedAt;
}
