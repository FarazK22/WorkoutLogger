package model.exercises;

import model.exercises.Exercise;

// Extends the exercise class and adds on a repetitions field and weight field
// to record repetitions of a certain weight completed in a strength exercise

public class StrengthExercise extends Exercise {

    private String exerciseType;
    private String exerciseName;
    private int weight;
    private int repetitions;



    // REQUIRES: - name must be non-empty
    //           - exerciseType must be one of "Endurance", "Flexibility", "Strength"
    //           - dur, reps, and lb must be > 0
    // MODIFIES: this
    // EFFECTS:  sets the exercise name, exercise type, duration, repetitions done, and weight lifted according to
    //           the input values
    public StrengthExercise(String name, String exerciseType, int dur, int reps, int lb) {
        super(name, exerciseType, dur);
        this.repetitions = reps;
        this.weight = lb;
    }

    // EFFECTS: returns the weight lifted for this exercise
    public int getWeight() {
        return this.weight;
    }

    // EFFECTS: returns the amount of repetitions done
    public int getRepetitions() {
        return this.repetitions;
    }





}
