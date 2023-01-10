package my.fitnessbackend;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "exercise")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Exercise {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "muscle", nullable = false)
    private String muscle;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    public Exercise() {
    }

    public Exercise(
            String name,
            String muscle,
            String description,
            String difficulty) {
        this.name = name;
        this.muscle = muscle;
        this.description = description;
        this.difficulty = difficulty;

    }
}
