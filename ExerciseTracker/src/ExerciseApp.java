/*
 * Wiktoria Cioch-Gradzik
 * 11/10/2023
 * FA23-CPSC-24500-002
 * This program is keeping track of exercise and count the number of calories burned
 * It shows the Run walk, climbing and weight lifting information including date, time, name and burned calories
 * It sorts it by date or by burned calories
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class ExerciseApp {
    /**
     * This function is printing the welcome banner
     */
    public static void printWelcome(){
        System.out.println("*".repeat(80));
        System.out.printf("%51s\n","EXERCISE TRACKER V1.0");
        System.out.println("*".repeat(80));
    }

    /**
     * This function is printing the menu
     */
    public static void printMenu(){
        System.out.println();
        System.out.println("These are your choices:");
        System.out.println("1. Add an exercise");
        System.out.println("2. Print exercises to file");
        System.out.println("3. List sorted by date");
        System.out.println("4. List sorted by calories burned");
        System.out.println("5. Exit");
        System.out.print("Enter the number of your choice: ");
    }
    public static void main(String[] args){
        //it creates a scanner and ArrayList, which will contain Exercise objects
        Scanner scan;
        Scanner s;
        Scanner sc = new Scanner(System.in);
        Scanner st = new Scanner(System.in);
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        Exercise e;
        printWelcome();
        int userChoice=0;
        double duration,poundsLifted,distance,wallH;
        int reps;
        String userChoiceE, name, date, comment, fileName;
        //its creating a loop, which will print a menu and take the options from user until user wont enter 5
        //if user will enter wrong number or word program will show a proper message and give possibility to enter the choice again
        do {
            printMenu();
            scan = new Scanner(System.in);
            try {
                userChoice = scan.nextInt();

            }catch (Exception c){
                System.out.println("You needed to enter an integer. Try again.");
                continue;
            }
            //its creating Excercise object with date provides from user
            if(userChoice == 1){
                System.out.println("Describe your workout:");
                do {
                    System.out.print("Enter R for run/walk, W for weightlifting, or C for rock climbing: ");
                    userChoiceE = st.nextLine();
                    if(!(userChoiceE.equals("W")||(userChoiceE.equals("R"))||(userChoiceE.equals("C")))){
                        System.out.println();
                        System.out.println("This character in not in list.");
                    }
                }while(!(userChoiceE.equals("W")||(userChoiceE.equals("R"))||(userChoiceE.equals("C"))));

                System.out.print("Enter a name for the workout: ");
                s = new Scanner(System.in);
                name = s.nextLine();
                System.out.print("Enter date of workout: ");
                date = s.nextLine();
                System.out.print("How long did you work out in minutes: ");
                duration = s.nextDouble();
                if(userChoiceE.equals("R")){
                    System.out.print("Enter distance you ran or walked in miles: ");
                    distance = s.nextDouble();
                    System.out.print("Enter a comment about the workout: ");
                    comment = sc.nextLine();
                    e = new RunWalk(name,comment,duration,date,distance);
                    exercises.add(e);
                }else if(userChoiceE.equals("W")){
                    System.out.print("Enter total weight lifted in pounds: ");
                    poundsLifted = s.nextDouble();
                    System.out.print("Enter a comment about the workout: ");
                    comment = sc.nextLine();
                    e = new Weightlifting(name,comment,duration,date,poundsLifted);
                    exercises.add(e);
                }else {
                    System.out.print("Enter the height of the wall in feet: ");
                    wallH = s.nextDouble();
                    System.out.print("Enter number of times you climbed it: ");
                    reps = s.nextInt();
                    System.out.print("Enter a comment about the workout: ");
                    comment = sc.nextLine();
                    e = new RockClimbing(name,comment,duration,date,wallH,reps);
                    exercises.add(e);
                }
                //its calling the writeToFile function and its returning if it was successful
            } else if(userChoice == 2){
                System.out.print("Enter the name of the file to save: ");
                fileName = sc.nextLine();
                if (ExerciseWriter.writeToFile(exercises,fileName)){
                    System.out.println("Your exercises were written to the file.");
                }else{
                    System.out.println("The procedure failed");
                }

                //its calling to tabulateSummary function to print with natural order(by date)
            } else if(userChoice == 3) {
                Collections.sort(exercises);
                ExerciseWriter.tabulateSummary(exercises);
            //its calling to tabulateSummary function to print with order by burned calories
            } else if(userChoice == 4){
                Collections.sort(exercises, new ExerciseCompareByCalories());
                ExerciseWriter.tabulateSummary(exercises);
            }else if(userChoice == 5){
                break;
            }else{
                //System.out.println("Invalid number.");
                scan.reset();
            }

        }while(userChoice != 5);
        System.out.println("Congratulations on staying in shape!");
    }
}
