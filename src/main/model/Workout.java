package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Workout {

    protected double workoutCalories;
    // private int date;
    protected int workoutDuration;
    private ArrayList<Exercise> exercises;
    DecimalFormat df = new DecimalFormat("#.0");

    // Following averages were all found in Harvard Health Publishing

    public final double avgCalsBurntPerMinStrength = 4.5;
    public final double avgCalsBurntPerMinEndurance = 11.3;
    public final double avgCalsBurntPerMinFlexibility = 5.9;


    // MODIFIES: this
    // EFFECTS: Starts a new workout

    public Workout() {
        this.exercises = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds new exercise of exerciseType to the list of exercises
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        totalDuration(exercise);
        totalCaloriesBurnt(exercise);
    }


    // REQUIRES: non-empty list of exercises
    // MODIFIES: this
    // EFFECTS: totals the calories burnt in the exercise list
    public void totalCaloriesBurnt(Exercise e) {
        if (e.exerciseType.equals("Strength")) {
            this.workoutCalories += (avgCalsBurntPerMinStrength * ((e.duration * 1.0) / 60));
        } else if (e.exerciseType.equals("Flexibility")) {
            this.workoutCalories += (avgCalsBurntPerMinFlexibility * ((e.duration * 1.0) / 60));
        } else {
            this.workoutCalories += (avgCalsBurntPerMinEndurance * ((e.duration * 1.0) / 60));
        }
    }


    // REQUIRES: non-empty list of exercises
    // MODIFIES: this
    // EFFECTS: totals the duration of each exercise in the list so far
    public void totalDuration(Exercise e) {
        this.workoutDuration += e.duration;
    }

    public String getWorkoutCalories() {
        return df.format(this.workoutCalories);
    }

    public int getWorkoutDuration() {
        return this.workoutDuration;
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }


}
