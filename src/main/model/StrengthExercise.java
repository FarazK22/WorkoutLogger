package model;

import java.util.ArrayList;

public class StrengthExercise extends Exercise {

    private int weight;
    private int repetitions;



    // REQUIRES: - name must be non-empty
    //           - exerciseType must be one of "Endurance", "Flexibility", "Strength"
    //           - dur, reps, and lb must be > 0
    // MODIFIES: this
    // EFFECTS:  sets the exercise name, exercise type, duration, repetitions done, and weight lifted according to
    //           the input values
    public StrengthExercise(String name, String exerciseType, double dur, int reps, int lb) {
        super(exerciseType, name, dur);
        this.repetitions = reps;
        this.weight = lb;
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
