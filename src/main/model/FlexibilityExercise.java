package model;

public class FlexibilityExercise extends Exercise {

    private String exerciseType;
    private String exerciseName;
    private int duration;
    private int repetitions;

    // REQUIRES: - name must be non-empty
    //           - exerciseType must be one of "Endurance", "Flexibility", "Strength"
    //           - dur and reps must be > 0
    // MODIFIES: this
    // EFFECTS:  sets the exercise name, exercise type, duration (in seconds), and repetitions done
    public FlexibilityExercise(String name, String exerciseType, int dur, int reps) {
        super(name, exerciseType, dur);
        this.repetitions = reps;
    }

    // EFFECTS: returns the amount of repetitions done
    public int getRepetitions() {
        return this.repetitions;
    }

}


