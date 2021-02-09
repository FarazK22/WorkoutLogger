package model;

public abstract class Exercise {
    protected String exerciseType;
    protected String exerciseName;
    protected double duration;

    // REQUIRES: - name must be non-empty
    //           - exerciseType must be one of "Endurance", "Flexibility", "Strength"
    //           - dur must be > 0
    // MODIFIES: this
    // EFFECTS:  sets the exercise name, exercise type, and duration in seconds

    public Exercise(String name, String exerciseType, double dur) {
        this.exerciseType = exerciseType;
        this.exerciseName = name;
        this.duration = dur;
    }

    // EFFECTS: returns the exercise name
    public String getExerciseName() {
        return null;
    }

    // EFFECTS: returns the exercise type
    public String getExerciseType() {
        return null; // STUB
    }

    // EFFECTS: returns the duration
    public double getDuration() {
        return 0.0; // STUB
    }
}
