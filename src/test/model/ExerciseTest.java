package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {

    @Test
    public void isEnduranceType(){
        Exercise test = new Exercise("Endurance", 10);
        assertEquals("Endurance", test.getExerciseType());
    }

    @Test
    public void isStrengthType(){
        Exercise test = new Exercise("Strength", 15);
        assertEquals("Strength", test.getExerciseType());
    }

    @Test
    public void isFlexibilityType(){
        Exercise test = new Exercise("Flexibility", 25);
        assertEquals("Flexibility", test.getExerciseType());
    }

    @Test
    public void distanceIntensity() {
        Exercise test = new Exercise("Endurance", 10);
        assertEquals("Distance", test.getIntensityType());
    }

    @Test
    public void setIntensity() {
        Exercise test = new Exercise("Strength", 20);
        assertEquals("Sets", test.getIntensityType());
    }

    @Test
    public void timeIntensity() {
        Exercise test = new Exercise("Flexibility", 30);
        assertEquals("Time", test.getIntensityType());
    }








}