package persistence;

import model.Workout;
import model.WorkoutLog;
import model.exercises.EnduranceExercise;
import model.exercises.Exercise;
import model.exercises.FlexibilityExercise;
import model.exercises.StrengthExercise;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            WorkoutLog wl = new WorkoutLog();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkoutLog() {
        try {
            WorkoutLog wl = new WorkoutLog();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkoutLog.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkoutLog.json");
            wl = reader.read();
            assertEquals("My log", wl.getName());
            assertEquals(0, wl.getTotalCalories());
            assertEquals(0, wl.getTotalDuration());
            assertEquals(0, wl.getWorkouts().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterOneWorkoutLogAllExercises() {
        try {
            Workout w1 = new Workout("02/01/2021");
            Exercise e1 = new EnduranceExercise("Jog", "Endurance", 300, 2);
            Exercise e2 = new StrengthExercise("Deadlift", "Strength", 50, 8, 315);
            Exercise e3 = new FlexibilityExercise("Stretch", "Flexibility", 60, 10);
            w1.addExercise(e1);
            w1.addExercise(e2);
            w1.addExercise(e3);

            WorkoutLog wl = new WorkoutLog();
            wl.addWorkout(w1);

            JsonWriter writer = new JsonWriter("./data/testWriterOneWorkoutLog.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterOneWorkoutLog.json");
            wl = reader.read();
            assertEquals("My log", wl.getName());
            List<Workout> workouts = wl.getWorkouts();
            assertEquals(1, workouts.size());
            assertEquals(410, wl.getTotalDuration());
            assertEquals(66.2, wl.getTotalCalories());
            Workout firstWorkout = workouts.get(0);
            assertEquals("02/01/2021", firstWorkout.getDate());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
