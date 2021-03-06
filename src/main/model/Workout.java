package model;

import model.exercises.Exercise;
import org.json.JSONObject;
import persistence.Writable;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Represents a workout with the date the workout was completed, a list of completed exercises,
// a total workout duration, and the total calories burnt in the workout

public class Workout implements Writable {


    private String date;
    private ArrayList<Exercise> exercises;
    protected double workoutCalories;
    protected int workoutDuration;
    DecimalFormat df = new DecimalFormat("#.0");

    // Following averages were all found in Harvard Health Publishing

    public final double avgCalsBurntPerMinStrength = 4.5;
    public final double avgCalsBurntPerMinEndurance = 11.3;
    public final double avgCalsBurntPerMinFlexibility = 5.9;


    // REQUIRES: String must be in "MM/DD/YYYY" format
    // MODIFIES: this
    // EFFECTS: Starts a new workout
    public Workout(String date) {
        this.exercises = new ArrayList<>();
        this.date = date;
    }

    // MODIFIES: this
    // EFFECTS: adds new exercise of exerciseType to the list of exercises and calls methods to calculate:
    //          - exercise duration
    //          - calories burnt
    //          - and the date of the workout
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        totalDuration(exercise);
        totalCaloriesBurnt(exercise);
    }



    // REQUIRES: non-empty list of exercises
    // MODIFIES: this
    // EFFECTS: totals the calories burnt in the exercise list
    public void totalCaloriesBurnt(Exercise e) {
        if (e.getExerciseType().equals("Strength")) {
            this.workoutCalories += (avgCalsBurntPerMinStrength * ((e.getDuration() * 1.0) / 60));
        } else if (e.getExerciseType().equals("Flexibility")) {
            this.workoutCalories += (avgCalsBurntPerMinFlexibility * ((e.getDuration() * 1.0) / 60));
        } else {
            this.workoutCalories += (avgCalsBurntPerMinEndurance * ((e.getDuration() * 1.0) / 60));
        }
    }


    // REQUIRES: non-empty list of exercises
    // MODIFIES: this
    // EFFECTS: totals the duration of each exercise in the list so far
    public void totalDuration(Exercise e) {
        this.workoutDuration += e.getDuration();
    }

    // EFFECTS: Returns the date in a string with the format "MM/DD/YYYY"
    public String getDate() {
        return this.date;
    }

    // getters
    public String getWorkoutCalories() {
        return df.format(this.workoutCalories);
    }

    public int getWorkoutDuration() {
        return this.workoutDuration;
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }


    // EFFECTS: converts workout object to JSON and returns it
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("date", this.date);
        json.put("exercises", this.exercises);
        json.put("calories", this.getWorkoutCalories());
        json.put("duration", this.workoutDuration);

        return json;
    }
}
