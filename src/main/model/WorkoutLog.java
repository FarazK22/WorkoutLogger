package model;

import java.util.ArrayList;

public class WorkoutLog {

    protected ArrayList<Workout> workouts;
    protected int totalDuration;

    // MODIFIES: This
    // EFFECTS: Initializes a workout log with no workouts
    public WorkoutLog() {
        this.workouts = new ArrayList<>();
    }

    // REQUIRES: Workout must be populated with exercises
    // MODIFIES: This
    // EFFECTS: adds workout to the list of workouts in the log

    public void addWorkout(Workout workout) {
        workouts.add(workout);
        totalDurationOfWorkout(workout);
    }

    // EFFECTS: calculates the total duration from all the workouts in the current log
    public void totalDurationOfWorkout(Workout w) {
        this.totalDuration += w.workoutDuration;
    }

    // getters

    public ArrayList<Workout> getWorkouts() {
        return this.workouts;
    }


    public double getTotalDuration() {
        return this.totalDuration;
    }


}
