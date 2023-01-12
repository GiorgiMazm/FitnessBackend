package my.fitnessbackend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
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
                + "to post new Exercise: /newExercise"
                + "<br>"
                + "to delete an Exercise: /delete{id}"
                + "<br>"
                + "to put Exercise: /edit{id]";
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
    public void updateExercise(@PathVariable(value = "exerciseId") Long exerciseId, @RequestBody Exercise newExercise) {
        Exercise exercise = exerciseRepository.findById(exerciseId).get();
        log.info(String.valueOf(exercise));

        exercise.setName(newExercise.getName());
        exercise.setDifficulty(newExercise.getDifficulty());
        exercise.setDescription(newExercise.getDescription());
        exercise.setMuscleGroup(newExercise.getMuscleGroup());
        exerciseRepository.save(exercise);
    }
}
