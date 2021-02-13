package model.exercises;

public abstract class Exercise {
    private String exerciseType;
    protected String exerciseName;
    private int duration;

    // REQUIRES: - name must be non-empty
    //           - exerciseType must be one of "Endurance", "Flexibility", "Strength"
    //           - dur must be > 0
    // MODIFIES: this
    // EFFECTS:  sets the exercise name, exercise type, and duration in seconds


    public Exercise(String name, String exerciseType, int dur) {
        this.exerciseName = name;
        this.exerciseType = exerciseType;
        this.duration = dur;
    }


    // EFFECTS: returns the exercise name
    public String getExerciseName() {
        return this.exerciseName;
    }

    // EFFECTS: returns the exercise type
    public String getExerciseType() {
        return this.exerciseType;
    }

    // EFFECTS: returns the duration
    public int getDuration() {
        return this.duration;
    }

}