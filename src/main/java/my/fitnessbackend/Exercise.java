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


    @Column(name = "muscle_group", nullable = false)
    private String muscleGroup;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    public Exercise() {
    }

    public Exercise(
            String name,
            String muscleGroup,
            String description,
            String difficulty) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.description = description;
        this.difficulty = difficulty;

    }
}
