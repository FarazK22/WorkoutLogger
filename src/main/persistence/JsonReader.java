package persistence;

import model.Workout;
import model.WorkoutLog;
import model.exercises.EnduranceExercise;
import model.exercises.Exercise;
import model.exercises.FlexibilityExercise;
import model.exercises.StrengthExercise;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads a workout log from JSON data stored in file
// - methods referenced from the CPSC 210 JsonSerializationDemo.java file

public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workout log from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workout log from JSON object and returns it
    private WorkoutLog parseWorkoutLog(JSONObject jsonObject) {
        WorkoutLog wl = new WorkoutLog();
        addNextWorkout(wl, jsonObject);
        return wl;
    }

    // MODIFIES: wl
    // EFFECTS: adds the next workout with a list of exercises to the workout log (wl)
    private void addNextWorkout(WorkoutLog wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("workouts");
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            Workout chosenWorkout = parseWorkout(nextWorkout);
            wl.addWorkout(chosenWorkout);
        }
    }


    // EFFECTS: parses workout from JSON object and returns it
    private Workout parseWorkout(JSONObject jsonObject) {
        String workoutDate = jsonObject.getString("date");
        Workout wo = new Workout(workoutDate);
        addExercises(wo, jsonObject);
        return wo;
    }

    // MODIFIES: wo
    // EFFECTS: parses proper exercises from JSON object and adds them to workout
    private void addExercises(Workout wo, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            Exercise chosenExercise = chooseExercise(wo, nextExercise);
            wo.addExercise(chosenExercise);
        }
    }

    // EFFECTS: checks that exercise type is one of "Endurance", "Flexibility", and "Strength"
    //          - returns the corresponding exercise type
    private Exercise chooseExercise(Workout wo, JSONObject jsonObject) {
        String exerciseType = jsonObject.getString("exerciseType");
        if (exerciseType.equals("Endurance")) {
            Exercise chosenExercise = addEnduranceExercise(wo, jsonObject);
            return chosenExercise;
        } else if (exerciseType.equals("Flexibility")) {
            Exercise chosenExercise = addFlexibilityExercise(wo, jsonObject);
            return chosenExercise;
        } else {
            Exercise chosenExercise = addStrengthExercise(wo, jsonObject);
            return chosenExercise;
        }
    }

    // EFFECTS: parses endurance exercise from JSON file and returns it
    private Exercise addEnduranceExercise(Workout wo, JSONObject jsonObject) {
        String name = jsonObject.getString("exerciseName");
        String exerciseType = jsonObject.getString("exerciseType");
        int duration = jsonObject.getInt("duration");
        double distance = jsonObject.getDouble("distance");
        EnduranceExercise exercise = new EnduranceExercise(name, exerciseType, duration, distance);
        return exercise;

    }

    // EFFECTS: parses flexibility exercise from JSON file and returns it
    private Exercise addFlexibilityExercise(Workout wo, JSONObject jsonObject) {
        String name = jsonObject.getString("exerciseName");
        String exerciseType = jsonObject.getString("exerciseType");
        int duration = jsonObject.getInt("duration");
        int reps = jsonObject.getInt("repetitions");
        FlexibilityExercise exercise = new FlexibilityExercise(name, exerciseType, duration, reps);
        return exercise;
    }


    // EFFECTS: parses strength exercise from JSON object and adds it to workroom
    private Exercise addStrengthExercise(Workout wo, JSONObject jsonObject) {
        String name = jsonObject.getString("exerciseName");
        String exerciseType = jsonObject.getString("exerciseType");
        int duration = jsonObject.getInt("duration");
        int lb = jsonObject.getInt("weight");
        int reps = jsonObject.getInt("repetitions");
        StrengthExercise exercise = new StrengthExercise(name, exerciseType, duration, reps, lb);
        return exercise;
    }

}
