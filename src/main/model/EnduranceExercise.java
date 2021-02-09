package model;

import java.util.ArrayList;

public class EnduranceExercise extends Exercise {

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
        super(name, exerciseType, dur);
        this.distance = dist;
    }


    // EFFECTS: returns the distance travelled in km
    public int getDistance() {
        return 0; // STUB
    }
}
