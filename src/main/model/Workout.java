package model;

import java.util.ArrayList;

public class Workout {

    private int calories;
    private int date;
    private int duration;
    private ArrayList<Exercise> log;

    // Following averages were all found in Harvard Health Publishing, averages and ballpark ranges

    private final double avgCalsBurntPerMinStrength = 4.5;
    private final double avgCalsBurntPerMinEndurance = 11.3;
    private final double avgCalsBurntPerMinFlexibility = 5.9;



    // REQUIRES:
    // MODIFIES: This
    // EFFECTS: Workout has burned the input calories on the given date, duration deter

    public Workout(int cals, int date) {
        this.calories = cals;
        this.date = date;
        this.duration = totalDuration();
        // this.log = new ArrayList<Exercise>();

    }

    // REQUIRES: non-empty list of exercises
    // EFFECTS: totals the duration of each exercise in the log
    private int totalDuration() {
        return 0; //STUB

    }



}
