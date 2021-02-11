package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutTest {

    private Workout testWorkout;
    private Exercise e1;
    private Exercise e2;
    private Exercise e3;
    private Exercise e4;
    private Exercise e5;

    @BeforeEach
    private void runBefore() {
        testWorkout = new Workout();
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


        assertEquals("113.0", testWorkout.getCalories());
    }

    @Test
    public void testTotalCaloriesSome() {
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);

        assertEquals("294.5", testWorkout.getCalories());
    }

    @Test
    public void testTotalCaloriesMany() {
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e3);

        assertEquals("413.4", testWorkout.getCalories());
    }

    @Test
    public void testTotalDurationOne() {
        testWorkout.addExercise(e5);

        assertEquals(1530, testWorkout.getDuration());
    }

    @Test
    public void testTotalDurationSome() {
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e3);

        assertEquals(660, testWorkout.getDuration());
    }

    @Test
    public void testTotalDurationMany() {
        testWorkout.addExercise(e2);
        testWorkout.addExercise(e4);
        testWorkout.addExercise(e5);
        testWorkout.addExercise(e1);
        testWorkout.addExercise(e3);

        assertEquals(2275, testWorkout.getDuration());
    }


}
