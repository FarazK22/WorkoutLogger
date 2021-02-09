package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlexibilityExerciseTest {

    private FlexibilityExercise testExercise;

    @BeforeEach
    public void runBefore() {
        testExercise = new FlexibilityExercise("Hamstring Stretch", "Flexibility", 25, 5);
    }

    @Test
    public void getNameTest() {
        assertEquals("Hamstring Stretch", testExercise.getExerciseName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Flexibility", testExercise.getExerciseType());
    }

    @Test
    public void getDurationTest() {
        assertEquals(25, testExercise.getDuration());
    }

    @Test
    public void getRepTest() {
        assertEquals(5, testExercise.getRepetitions());
    }
}
