package model;

import model.exercises.EnduranceExercise;
import model.exercises.Exercise;
import model.exercises.FlexibilityExercise;
import model.exercises.StrengthExercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutLogTest {

    private WorkoutLog testWorkoutLog;

    private Workout w1;
    private Workout w2;
    private Workout w3;
    private Workout w4;

    private Exercise e1;
    private Exercise e2;
    private Exercise e3;
    private Exercise e4;
    private Exercise e5;


    @BeforeEach
    public void runBefore() {
        testWorkoutLog = new WorkoutLog();

        w1 = new Workout("02/12/2021");
        w2 = new Workout("02/10/2021");
        w3 = new Workout("01/12/2021");
        w4 = new Workout("01/25/2021");

        e1 = new EnduranceExercise("Biking", "Endurance", 600, 8);
        e2 = new StrengthExercise("Bench Press", "Strength", 45, 8, 225);
        e3 = new FlexibilityExercise("Side Lunge", "Flexibility", 60, 10);
        e4 = new StrengthExercise("Deadlift", "Strength", 40, 4, 275);
        e5 = new EnduranceExercise("Jog", "Endurance", 1530, 5.5);

        w1.addExercise(e1);
        w1.addExercise(e2);
        w1.addExercise(e2);
        w1.addExercise(e3);

        w2.addExercise(e4);
        w2.addExercise(e5);
        w2.addExercise(e2);

        w3.addExercise(e1);
        w3.addExercise(e5);

        w4.addExercise(e5);

    }

    @Test
    public void testAddOneWorkout() {
        testWorkoutLog.addWorkout(w1);
        assertEquals(1, testWorkoutLog.getWorkouts().size());
    }

    @Test
    public void testAddTwoSameWorkout() {
        testWorkoutLog.addWorkout(w1);
        testWorkoutLog.addWorkout(w1);

        assertEquals(2, testWorkoutLog.getWorkouts().size());

    }

    @Test
    public void testAddSomeWorkouts() {
        testWorkoutLog.addWorkout(w1);
        testWorkoutLog.addWorkout(w2);
        testWorkoutLog.addWorkout(w3);

        assertEquals(3, testWorkoutLog.getWorkouts().size());
    }

    @Test
    public void testAddManyWorkouts() {
        testWorkoutLog.addWorkout(w1);
        testWorkoutLog.addWorkout(w1);
        testWorkoutLog.addWorkout(w2);
        testWorkoutLog.addWorkout(w2);
        testWorkoutLog.addWorkout(w3);
        testWorkoutLog.addWorkout(w4);
        testWorkoutLog.addWorkout(w4);

        assertEquals(7, testWorkoutLog.getWorkouts().size());
    }

    @Test
    public void totalOneWorkoutOneExerciseCalorie() {
        testWorkoutLog.addWorkout(w4);

        assertEquals(288.2, testWorkoutLog.getTotalCalories());

    }

    @Test
    public void totalOneWorkoutManyExerciseCalorie(){
        testWorkoutLog.addWorkout(w3);

        assertEquals(401.2, testWorkoutLog.getTotalCalories());
    }

    @Test
    public void testSomeWorkoutCalories() {
        testWorkoutLog.addWorkout(w3);
        testWorkoutLog.addWorkout(w4);

        assertEquals(689.4, testWorkoutLog.getTotalCalories());
    }

    @Test
    public void testManyWorkoutCalories() {
        testWorkoutLog.addWorkout(w1);
        testWorkoutLog.addWorkout(w2);
        testWorkoutLog.addWorkout(w3);

        assertEquals(821.4, testWorkoutLog.getTotalCalories());
    }

    @Test
    public void testOneWorkoutOneExerciseDuration() {
        testWorkoutLog.addWorkout(w4);
        assertEquals(1530, testWorkoutLog.getTotalDuration());
    }

    @Test
    public void testOneWorkoutManyExerciseDuration() {
        testWorkoutLog.addWorkout(w2);
        assertEquals(1615, testWorkoutLog.getTotalDuration());
    }

    @Test
    public void testSomeWorkoutDuration() {
        testWorkoutLog.addWorkout(w3);
        testWorkoutLog.addWorkout(w2);

        assertEquals(3745, testWorkoutLog.getTotalDuration());
    }

    @Test
    public void testManyWorkoutDurations() {
        testWorkoutLog.addWorkout(w1);
        testWorkoutLog.addWorkout(w2);
        testWorkoutLog.addWorkout(w3);
        testWorkoutLog.addWorkout(w4);

        assertEquals(6025, testWorkoutLog.getTotalDuration());
    }

    @Test
    public void testPrintWorkoutOne() {
        testWorkoutLog.addWorkout(w1);

        assertEquals("0 02/12/2021 - Approximately 125.7 calories burned!\n", testWorkoutLog.printWorkouts());
    }

    @Test
    public void testPrintMultiWorkouts() {
        testWorkoutLog.addWorkout(w3);
        testWorkoutLog.addWorkout(w4);
        testWorkoutLog.addWorkout(w2);
        testWorkoutLog.addWorkout(w1);

        assertEquals("0 01/12/2021 - Approximately 401.2 calories burned!\n"
                + "1 01/25/2021 - Approximately 288.2 calories burned!\n"
                + "2 02/10/2021 - Approximately 294.5 calories burned!\n"
                + "3 02/12/2021 - Approximately 125.7 calories burned!\n", testWorkoutLog.printWorkouts());
    }


}
