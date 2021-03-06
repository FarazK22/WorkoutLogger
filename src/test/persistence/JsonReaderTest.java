package persistence;

import model.Workout;
import model.WorkoutLog;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WorkoutLog wl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkoutLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkoutLog.json");
        try {
            WorkoutLog wl = reader.read();
            assertEquals("My log", wl.getName());
            assertEquals(0, wl.getTotalCalories());
            assertEquals(0, wl.getTotalDuration());
            assertEquals(0, wl.getWorkouts().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderOneWorkoutLog() {
        JsonReader reader = new JsonReader("./data/testReaderOneWorkoutLog.json");
        try {
            WorkoutLog wl = reader.read();
            assertEquals("My log", wl.getName());
            List<Workout> workouts = wl.getWorkouts();
            assertEquals(1, workouts.size());
            assertEquals(350, wl.getTotalDuration());
            assertEquals(60.2, wl.getTotalCalories());
            Workout firstWorkout = workouts.get(0);
            assertEquals("02/01/2021", firstWorkout.getDate());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
