package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class WorkoutLog {

    protected ArrayList<Workout> workouts;
    protected int totalDuration;
    protected double totalCalories;
    DecimalFormat df = new DecimalFormat("#.0");

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
        totalDurationOfLog(workout);
        totalCaloriesOfLog(workout);
    }

    // REQUIRES: non-empty workout log
    // MODIFIES: this
    // EFFECTS: prints out all workouts in the log with calories burned
    public String printWorkouts() {
        int i = 0;
        String print = "";
        for (Workout w : workouts) {
            print += i + " " + w.getDate() + " - Approximately " + df.format(w.workoutCalories) + " calories burned!"
                    + "\n";
            i++;
        }
        return print;
    }

    // EFFECTS: calculates the total duration from all the workouts in the current log
    public void totalDurationOfLog(Workout w) {
        this.totalDuration += w.workoutDuration;
    }

    // EFFECTS: calculate the total calories from all the workouts in the current log
    public void totalCaloriesOfLog(Workout w) {
        double calories = Double.parseDouble(w.getWorkoutCalories());
        this.totalCalories += calories;
    }

    // getters

    public ArrayList<Workout> getWorkouts() {
        return this.workouts;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public double getTotalCalories() {
        return this.totalCalories;
    }


}
