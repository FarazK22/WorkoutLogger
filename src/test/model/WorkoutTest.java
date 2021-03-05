package model;

import model.exercises.EnduranceExercise;
import model.exercises.Exercise;
import model.exercises.FlexibilityExercise;
import model.exercises.StrengthExercise;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutTest {

    private Workout testWorkout;
    private Exercise e1;
    private Exercise e2;
    private Exercise e3;
    private Exercise e4;
    private Exercise e5;

    @BeforeEach
    public void runBefore() {
        testWorkout = new Workout("02/10/2021");
        e1 = new EnduranceExercise("Biking", "Endurance", 600, 8);
        e2 = new StrengthExercise("Bench Press", "Strength", 45, 8, 225);
        e3 = new FlexibilityExercise("Side Lunge", "Flexibility", 60, 10);
        e4 = new StrengthExercise("Deadlift", "Strength", 40, 4, 275);
        e5 = new EnduranceExercise("Jog", "Endurance", 1530, 5.5);

    }

    @Test
    public void testOneAddedExercise() {

        testWorkout.addExercise(e1);
        assertEquals(1, testWorkout.getExercises().size());

    }

    @Test
    public void testSomeAddedExercises() {

        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);

        assertEquals(3, testWorkout.getExercises().size());
    }

    @Test
    public void testManyAddedExercises() {

        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e3);

        assertEquals(5, testWorkout.getExercises().size());

    }

    @Test
    public void testSameExerciseAddedMultipleTimes() {
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e2);

        assertEquals(3, testWorkout.getExercises().size());

    }

    @Test
    public void testTotalCaloriesOne() {
        testWorkout.addExercise(e1);


        assertEquals("113.0", testWorkout.getWorkoutCalories());
    }

    @Test
    public void testTotalCaloriesSome() {
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);

        assertEquals("294.5", testWorkout.getWorkoutCalories());
    }

    @Test
    public void testTotalCaloriesMany() {
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e3);

        assertEquals("413.4", testWorkout.getWorkoutCalories());
    }

    @Test
    public void testTotalDurationOne() {
        testWorkout.addExercise(e5);

        assertEquals(1530, testWorkout.getWorkoutDuration());
    }

    @Test
    public void testTotalDurationSome() {
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e3);

        assertEquals(660, testWorkout.getWorkoutDuration());
    }

    @Test
    public void testTotalDurationMany() {
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e3);

        assertEquals(2275, testWorkout.getWorkoutDuration());
    }

    @Test
    public void testGetDateOneAddition() {
        testWorkout.addExercise(e1);

        assertEquals("02/10/2021", testWorkout.getDate());
    }

    @Test
    public void testGetDateMultipleAddition() {
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e3);


        assertEquals("02/10/2021", testWorkout.getDate());
    }

    @Test
    public void testToJSON() {
        testWorkout.addExercise(e1);
        JSONObject json = new JSONObject();
        json.put("date", "02/10/2021");
        json.put("exercises", testWorkout.getExercises());
        json.put("calories", testWorkout.getWorkoutCalories());
        json.put("duration", testWorkout.getWorkoutDuration());

        assertEquals(json.toString(), testWorkout.toJson().toString());


    }

    @Test
    public void testToJSONMultiExercise() {
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e2);

        JSONObject json = new JSONObject();
        json.put("date", "02/10/2021");
        json.put("exercises", testWorkout.getExercises());
        json.put("calories", testWorkout.getWorkoutCalories());
        json.put("duration", testWorkout.getWorkoutDuration());

        assertEquals(json.toString(), testWorkout.toJson().toString());

    }


}
