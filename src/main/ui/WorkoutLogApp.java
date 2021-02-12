//package ui;
//
//import model.*;
//
//import java.util.Scanner;
//
//public class WorkoutLogApp {
//
//    private Workout workout1;
//    private Workout workout2;
//    private Scanner input;
//
//
//    private Exercise e1 = new EnduranceExercise("Jog", "Endurance", 300, 2);
//    private Exercise e2 = new StrengthExercise("Deadlift", "Strength", 50, 8, 315);
//    private Exercise e3 = new FlexibilityExercise("Lunge", "Flexibility", 60, 10);
//    private Exercise e4 = new EnduranceExercise("Biking", "Endurance", 600, 6);
//
//    // EFFECTS: Runs workout log app
//    public WorkoutLogApp() {
//        runLog();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user input
//    private void runLog() {
//        boolean keepGoing = true;
//        String command = null;
//
//        boot();
//
//        while (keepGoing) {
//            displayMenu();
//            command = input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//
//        System.out.println("\nGoodbye!");
//    }
//
//    // EFFECTS: processes the user input
//    private void processCommand(String command) {
//        if (command.equals("s")) {
//            startNewWorkout();
//        } else if (command.equals("v")) {
//            selectWorkout();
//        } else if (command.equals("e")) {
//            editWorkout();
//        } else {
//            System.out.println("Selection not valid...");
//        }
//    }
//
//
//
//    // EFFECTS: displays the home menu to users
//    private void displayMenu() {
//
//        System.out.println("\nWelcome to your workout log!");
//        System.out.println("\nSelect from:");
//        System.out.println("\ts -> start new workout");
//        System.out.println("\tv -> view workout");
//        System.out.println("\te -> edit workout");
//        System.out.println("\tq -> quit");
//    }
//
//    // MODIFIES: This
//    // EFFECTS: Starts up workout log app with two workouts already logged
//    private void boot() {
//
//        workout1 = new Workout();
//        workout1.addExercise(e1);
//        workout1.addExercise(e2);
//
//        workout2 = new Workout();
//        workout2.addExercise(e3);
//        workout2.addExercise(e4);
//
//        input = new Scanner(System.in);
//    }
//
//    private void startNewWorkout() {
//
////        Workout newWorkout = new Workout();
////        Exercise selected = selectExercise();
////        System.out.print("First exercise added!");
////        System.out.println("Would you like to add more? (y/n)");
////
////        if () {
////            selected.deposit(amount);
////        } else {
////            System.out.println("Cannot deposit negative amount...\n");
////        }
////
////        printBalance(selected);
//    }
//
//
//    private Exercise selectExercise() {
//        String selection = "";  // force entry into loop
//
//        while (!(selection.equals("s") || selection.equals("e") || selection.equals('f'))) {
//            System.out.println("s for Strength");
//            System.out.println("e for Endurance");
//            System.out.println("f for Flexibility");
//            selection = input.next();
//            selection = selection.toLowerCase();
//        }
//
//        if (selection.equals("s")) {
//            addStrengthExercise();
//        } else if (selection.equals("e")) {
//            addEnduranceExercise();
//        } else {
//            addFlexibilityExercise();
//        }
//
//    }
//
//    private void addStrengthExercise() {
//        System.out.println("Enter the name of the exercise, the duration (in seconds), the amount of reps done, " +
//                "and the amount of weight lifted (in lb)");
//
//        String name = input.nextLine();
//        int duration = input.nextInt();
//        int reps = input.nextInt();
//        int weight = input.nextInt();
//
//        StrengthExercise newExercise = new StrengthExercise(name, "Strength", duration, reps, weight);
//
//
//    }
//
//    private void addEnduranceExercise() {
//
//    }
//
//    private void addFlexibilityExercise() {
//
//    }
//}
//}