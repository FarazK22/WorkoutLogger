package persistence;

import org.json.JSONObject;

// Interface for the toJson method which is implemented in the workout and workout log classes

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
