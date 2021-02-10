package model;

import java.util.ArrayList;
import model.Exercise;

public class Workout {

    private double calories;
    // private int date;
    private int duration;
    private ArrayList<Exercise> exercises;

    // Following averages were all found in Harvard Health Publishing, averages and ballpark ranges

    public final double avgCalsBurntPerMinStrength = 4.5;
    public final double avgCalsBurntPerMinEndurance = 11.3;
    public final double avgCalsBurntPerMinFlexibility = 5.9;


    // MODIFIES: this
    // EFFECTS: Starts a new workout

    public Workout() {
        this.exercises = new ArrayList<>();
        this.duration = 0;
        totalCaloriesBurnt();
        totalDuration();

    }

    // MODIFIES: this
    // EFFECTS: adds new exercise of exerciseType to the list of exercises
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }


    // REQUIRES: non-empty list of exercises
    // MODIFIES: this
    // EFFECTS: totals the calories burnt in the exercise list
    public void totalCaloriesBurnt() {
        double csf = 0.0;
        for (Exercise e : this.exercises) {
            if (e.exerciseType.equals("Strength")) {
                csf += (avgCalsBurntPerMinStrength * (e.duration / 60));
            } else if (e.exerciseType.equals("Flexibility")) {
                csf += (avgCalsBurntPerMinFlexibility * (e.duration / 60));
            } else {
                csf += (avgCalsBurntPerMinEndurance * (e.duration / 60));
            }
        }
        this.calories = csf;
    }


    // REQUIRES: non-empty list of exercises
    // MODIFIES: this
    // EFFECTS: totals the duration of each exercise in the list so far
    public void totalDuration() {

        for (Exercise e : exercises) {
            this.duration += e.duration;
        }
    }

    public double getCalories() {
        return this.calories;
    }

    public int getDuration() {
        return this.duration;
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }



}
