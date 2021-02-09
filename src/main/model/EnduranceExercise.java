package model;

import java.util.ArrayList;

public class EnduranceExercise implements Exercise {

    private String exerciseType;
    private String exerciseName;
    private double duration;
    private double distance;

    // REQUIRES: - name must be non-empty
    //           - exerciseType must be one of "Endurance", "Flexibility", "Strength"
    //           - dur and dist must be > 0
    // MODIFIES: this
    // EFFECTS:  sets the exercise name, exercise type, duration (in seconds), and distance (in meters)

    public EnduranceExercise(String name, String exerciseType, double dur, double dist) {
        this.exerciseName = name;
        this.exerciseType = exerciseType;
        this.duration = dur;
        this.distance = dist;

    }


    @Override
    public String getExerciseName() {
        return null;
    }

    @Override
    public String getExerciseType() {
        return null;
    }

    @Override
    public double getDuration() {
        return 0;
    }

    @Override
    public double totalCaloriesBurned() {
        return 0;
    }

    @Override
    public double totalDuration() {
        return 0;
    }
}
