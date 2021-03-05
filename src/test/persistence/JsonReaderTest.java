package persistence;

import model.Workout;
import model.WorkoutLog;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WorkoutLog wl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

//    @Test
//    void testReaderEmptyWorkRoom() {
//        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
//        try {
//            WorkoutLog wl = reader.read();
//            assertEquals("My work room", wl.getName());
//            assertEquals(0, wl.numThingies());
//        } catch (IOException e) {
//            fail("Couldn't read from file");
//        }
//    }
}
