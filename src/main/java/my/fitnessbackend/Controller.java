package my.fitnessbackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class Controller {

    ExerciseRepository exerciseRepository;

    public Controller(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping(path = "/")
    public String home() {
        return "Welcome to Fitness Backend!"
                + "<br>"
                + "to get all Exercises:  /allExercises"
                + "<br>"
                + "to post new Exercise: /newExercise";
    }

    @GetMapping(path = "allExercises")
    public List<Exercise> test() {
        return exerciseRepository.findAll();
    }

    @PostMapping("newExercise")
    public void registerNewExercise(@RequestBody Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @DeleteMapping(path = "delete{exerciseId}")
    public void deleteExercise(@PathVariable("exerciseId") Long exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }

    @PutMapping(path = "edit{exerciseId}")
    public void updateExercise(@PathVariable(value = "exerciseId") Long exerciseId, @RequestParam(required = false) String name) {
        Optional<Exercise> exercise = exerciseRepository.findById(exerciseId);
        Exercise exerciseObject = exercise.get();
        exerciseObject.setName(name);
        exerciseRepository.save(exerciseObject);
    }
}
