package model;

import java.util.ArrayList;

public class WorkoutLog {

    private ArrayList<Workout> workouts;
   // private double totalCalories;
    private double totalDuration;

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
    }

    // EFFECTS: calculates the total calories from all the workouts in the current log
    // public void totalCaloriesBurnt(){ }


    // EFFECTS: calculates the total duration from all the workouts in the current log
    public void totalDurationOfWorkout(){}


    // getters

    public ArrayList<Workout> getWorkouts() {
        return this.workouts;
    }

   // public double getTotalCalories() {
   //     return this.totalCalories;
   // }

    public double getTotalDuration() {
        return this.totalDuration;
    }


}
