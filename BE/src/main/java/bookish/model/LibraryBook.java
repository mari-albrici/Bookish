import jakarta.persistence.*; // For JPA annotations
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

import bookish.model.Review;

@Getter
@Setter
@Entity 
public class LibraryBook {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private UUID id;

    @ManyToOne /
    private UUID userId;

    @Column(nullable = false)
    private String bookISBN;

    @Enumerated(EnumType.STRING) 
    private BookStatus status;

    private LocalDateTime startDate; 
    private LocalDateTime endDate;   

    private Double rating;

    @ManyToOne // Assuming there's a Review entity
    private Review review;

    private LocalDateTime createdAt; 
    private LocalDateTime updatedAt; 

    public LibraryBook() {
    }
}
