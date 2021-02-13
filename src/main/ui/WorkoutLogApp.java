package ui;

import model.*;
import model.exercises.EnduranceExercise;
import model.exercises.Exercise;
import model.exercises.FlexibilityExercise;
import model.exercises.StrengthExercise;

import java.util.Scanner;

public class WorkoutLogApp {

    private WorkoutLog log;

    private Workout workout1;
    private Workout workout2;
    private Scanner input;


    private Exercise e1 = new EnduranceExercise("Jog", "Endurance", 300, 2);
    private Exercise e2 = new StrengthExercise("Deadlift", "Strength", 50, 8, 315);
    private Exercise e3 = new FlexibilityExercise("Lunge", "Flexibility", 60, 10);
    private Exercise e4 = new EnduranceExercise("Biking", "Endurance", 600, 6);

    // EFFECTS: Runs workout log app
    public WorkoutLogApp() {
        runLog();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runLog() {
        boolean keepGoing = true;
        String command = null;

        boot();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes the user input
    private void processCommand(String command) {
        if (command.equals("s")) {
            startNewWorkout();
        } else if (command.equals("v")) {
            selectWorkout();
        } else if (command.equals("e")) {
            editWorkout();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: presents list of selectable workouts for user to select and add exercises to
    private void editWorkout() {

    }

    // EFFECTS: presents list of selectable workouts for user to select and view total calories burnt
    private void selectWorkout() {
        int indexResponse = 0;
        System.out.println("Here is a summary of your workouts so far:");
        System.out.println(log.printWorkouts());


    }


    // EFFECTS: displays the home menu to users
    private void displayMenu() {

        System.out.println("\nWelcome to your workout log!");
        System.out.println("\nSelect from:");
        System.out.println("\ts -> start new workout");
        System.out.println("\tv -> view workout");
        System.out.println("\te -> edit workout");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: This
    // EFFECTS: Starts up workout log app with two workouts already logged
    private void boot() {

        workout1 = new Workout("02/01/2021");
        workout1.addExercise(e1);
        workout1.addExercise(e2);

        workout2 = new Workout("02/08/2021");
        workout2.addExercise(e3);
        workout2.addExercise(e4);

        log = new WorkoutLog();
        log.addWorkout(workout1);
        log.addWorkout(workout2);


        input = new Scanner(System.in);
    }

    // MODIFIES: This
    // EFFECTS: Starts a new workout and processes user input to determine when to stop adding workouts
    private void startNewWorkout() {

        boolean keepGoing = true;
        String date = todaysDate();
        Workout newWorkout = new Workout(date);
        String ynResponse = "";

        while (keepGoing) {
            Exercise selected = selectExercise();
            newWorkout.addExercise(selected);
            System.out.print("\nExercise added!");
            System.out.println("\nWould you like to add more? (y/n)");
            ynResponse = input.next();
            ynResponse = ynResponse.toLowerCase();

            if (ynResponse.equals("n")) {
                keepGoing = false;
                log.addWorkout(newWorkout);
            }
        }
    }

    // EFFECTS: Processes the user input as the date of the workout
    private String todaysDate() {
        System.out.println("Enter today's date in the format 'MM/DD/YYYY'");
        String date = input.next();
        return date;
    }


    // EFFECTS: Processes the user input to select which exercise type they will add to workout
    private Exercise selectExercise() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("s") || selection.equals("e") || selection.equals("f"))) {
            System.out.println("s for Strength");
            System.out.println("e for Endurance");
            System.out.println("f for Flexibility");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("s")) {
            Exercise newExercise = addStrengthExercise();
            return newExercise;
        } else if (selection.equals("e")) {
            Exercise newExercise = addEnduranceExercise();
            return newExercise;
        } else if (selection.equals("f")) {
            Exercise newExercise = addFlexibilityExercise();
            return newExercise;
        } else {
            return null;
        }
    }

    // REQUIRES: non-empty int
    // EFFECTS: processes the user input as the weight lifted for strength exercise
    private int inputExerciseWeight() {
        System.out.println("Enter the weight you just lifted (in lb)");
        int weight = input.nextInt();
        return weight;
    }

    // REQUIRES: non-empty int
    // EFFECTS: processes the user input as the repetitions completed
    private int inputExerciseRepetitions() {
        System.out.println("Enter the repetitions you just completed");
        int reps = input.nextInt();
        return reps;
    }

    // REQUIRES: non-empty int
    // EFFECTS: processes the user input as the duration
    private int inputExerciseDuration() {
        System.out.println("Enter the duration of the exercise (in seconds)");
        int duration = input.nextInt();
        return duration;
    }

    // REQUIRES: non-empty string
    // EFFECTS: processes the user input as the name of the exercise completed
    private String inputExerciseName() {
        System.out.println("Enter the name of the exercise you completed");
        String name = input.next();
        return name;
    }

    // REQUIRES: non-empty double
    // EFFECTS: processes the user input as the distance traveled in exercise (in km)
    private double inputDistance() {

        System.out.println("Enter the distance travelled (in km)");
        double inputDistance = input.nextDouble();
        return inputDistance;
    }

    // EFFECTS: inputs values from helper methods to assign exercise:
    //          - name
    //          - duration
    //          - repetitions
    //          - weight lifted
    private Exercise addStrengthExercise() {

        String name = inputExerciseName();
        int duration = inputExerciseDuration();
        int reps = inputExerciseRepetitions();
        int weight = inputExerciseWeight();

        StrengthExercise strengthExercise = new StrengthExercise(name, "Strength", duration, reps, weight);

        return strengthExercise;


    }

    // EFFECTS: inputs values from helper methods to assign exercise:
    //          - name
    //          - duration
    //          - distance travelled
    private Exercise addEnduranceExercise() {

        String name = inputExerciseName();
        int duration = inputExerciseDuration();
        double distance = inputDistance();

        EnduranceExercise enduranceExercise = new EnduranceExercise(name, "Endurance", duration, distance);

        return enduranceExercise;
    }

    // EFFECTS: inputs values from helper methods to assign exercise:
    //          - name
    //          - duration
    //          - repetitions
    private Exercise addFlexibilityExercise() {

        String name = inputExerciseName();
        int duration = inputExerciseDuration();
        int reps = inputExerciseRepetitions();

        FlexibilityExercise flexibilityExercise = new FlexibilityExercise(name, "Flexibility", duration, reps);

        return flexibilityExercise;
    }
}