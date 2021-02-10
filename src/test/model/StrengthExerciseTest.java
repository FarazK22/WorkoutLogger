package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrengthExerciseTest {

    private StrengthExercise testExercise;


    @BeforeEach
    void runBefore() {

        testExercise = new StrengthExercise("Bench Press", "Strength", 45, 8, 195);
    }

    @Test
    public void getNameTest(){
        assertEquals("Bench Press", testExercise.getExerciseName());
    }

    @Test
    public void getTypeTest(){
        assertEquals("Strength", testExercise.getExerciseType());
    }

    @Test
    public void getDurationTest(){
        assertEquals(45, testExercise.getDuration());
    }

    @Test
    public void getRepTest() {
        assertEquals(8, testExercise.getRepetitions());
    }

    @Test
    public void getWeightTest() {
        assertEquals(195, testExercise.getWeight());

    }

}