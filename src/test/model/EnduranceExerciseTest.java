package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnduranceExerciseTest {

    private EnduranceExercise testExercise;

    @BeforeEach
    public void runBefore() {
        testExercise = new EnduranceExercise("Bike Ride", "Endurance", 180, 2500);
    }

    @Test
    public void getNameTest() {
        assertEquals("Bike Ride", testExercise.getExerciseName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Endurance", testExercise.getExerciseType());
    }

    @Test
    public void getDurationTest() {
        assertEquals(180, testExercise.getDuration());
    }

    @Test
    public void getDistanceTest() {
        assertEquals(2500, testExercise.getDistance());
    }
}
