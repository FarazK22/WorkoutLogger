package model;

public class Exercise {

    private String exerciseType;
    private String intensityType;
    private double intensityLevel;


    // REQUIRES: exerciseCat must be "Endurance", "Strength", or "Flexibility"
    // MODIFIES: this
    public Exercise(String exerciseCat, double intensity) {
        this.exerciseType = exerciseCat;
        this.intensityType = setIntensityType(exerciseType);
        this.intensityLevel = intensity;

    }

    // REQUIRES: non-empty string
    // EFFECTS: produces specific intensity type corresponding to exercise type
    //          - if "Endurance" produces "Distance"
    //          - if "Strength" produces "Sets"
    //          - if "Flexibility" produces "Time"

    public String setIntensityType(String exerciseType) {
        if (exerciseType.equals("Endurance")) {
            return "Distance";
        }
        if (exerciseType.equals("Strength")) {
            return "Sets";

        } else {
            return "Time";
        }
    }

    public String getExerciseType() {
        return null;
    }

    public String getIntensityType() {
        return null;
    }

    public double getIntensityLevel() {
        return 0.0;
    }





}
