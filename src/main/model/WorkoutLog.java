package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.text.DecimalFormat;
import java.util.ArrayList;

// Represents a WorkoutLog with the name "My log", a list of workouts, the total duration of all workouts in the log,
// and the total calories burnt through all the workouts in the log

public class WorkoutLog implements Writable {

    protected final String name = "My log";
    protected ArrayList<Workout> workouts;
    protected int totalDuration;
    protected double totalCalories;
    DecimalFormat df = new DecimalFormat("#.0");

    // MODIFIES: This
    // EFFECTS: Initializes a workout log with no workouts and a name
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

    public String getName() {
        return this.name;
    }


    // EFFECTS: converts workout log to JSON object and returns it
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("workouts", workoutsToJson());
        json.put("duration", this.totalDuration);
        json.put("calories", this.totalCalories);

        return json;

    }

    // EFFECTS: converts workouts to JSON object and returns it
    public JSONArray workoutsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Workout w : this.workouts) {
            jsonArray.put(w.toJson());
        }

        return jsonArray;

    }



}
