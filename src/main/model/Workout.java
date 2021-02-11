package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

import model.Exercise;

public class Workout {

    private double calories;
    // private int date;
    private int duration;
    private ArrayList<Exercise> exercises;
    DecimalFormat df = new DecimalFormat("#.0");

    // Following averages were all found in Harvard Health Publishing, averages and ballpark ranges

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
            this.calories += (avgCalsBurntPerMinStrength * ((e.duration * 1.0) / 60));
        } else if (e.exerciseType.equals("Flexibility")) {
            this.calories += (avgCalsBurntPerMinFlexibility * ((e.duration * 1.0) / 60));
        } else {
            this.calories += (avgCalsBurntPerMinEndurance * ((e.duration * 1.0) / 60));
        }
    }


    // REQUIRES: non-empty list of exercises
    // MODIFIES: this
    // EFFECTS: totals the duration of each exercise in the list so far
    public void totalDuration(Exercise e) {
        this.duration += e.duration;
    }

    public String getCalories() {
        return df.format(this.calories);
    }

    public int getDuration() {
        return this.duration;
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }


}
