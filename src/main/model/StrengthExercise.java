package model;

import java.util.ArrayList;

public class StrengthExercise implements Exercise {

    private String exerciseType;
    private String exerciseName;
    private double duration;
    private int weight;
    private int repetitions;



    // REQUIRES: - name must be non-empty
    //           - exerciseType must be one of "Endurance", "Flexibility", "Strength"
    //           - dur, reps, and lb must be > 0
    // MODIFIES: this
    // EFFECTS:  sets the exercise name, exercise type, duration, repetitions done, and weight lifted according to
    //           the input values
    public StrengthExercise(String name, String exerciseType, double dur, int reps, int lb) {
        this.exerciseName = name;
        this.exerciseType = exerciseType;
        this.duration = dur;
        this.repetitions = reps;
        this.weight = lb;
    }


    // EFFECTS: returns the exercise name
    @Override
    public String getExerciseName() {
        return null;
    }

    // EFFECTS: returns the exercise type
    @Override
    public String getExerciseType() {
        return null; // STUB
    }

    // EFFECTS: returns the exercise duration
    @Override
    public double getDuration() {
        return 0.0; // STUB
    }

    @Override
    public double totalCaloriesBurned() {
        return 0;
    }

    @Override
    public double totalDuration() {
        return 0;
    }

    // EFFECTS: returns the weight lifted for this exercise
    public int getWeight() {
        return 0; // STUB
    }

    // EFFECTS: returns the amount of repetitions done
    public int getRepetitions() {
        return 0; // STUB
    }





}
