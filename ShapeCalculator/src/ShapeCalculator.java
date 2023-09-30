/*
Wiktoria Cioch-Gradzik
09/27/2023
FA23-CPSC-24500-002
The program is asking user about shape, computing the area and perimeter of circle, rectangle or triangle.
After that it will show the results.
 */
import java.util.Scanner;

public class ShapeCalculator {
    /**
     * This function is printing the welcome banner
     */
    public static void printWelcome() {
        System.out.println("*".repeat(65));
        System.out.printf("%41s\n", "SHAPE CALCULATOR");
        System.out.println("*".repeat(65));
        System.out.println();
    }
    public static void main(String[] args){

        //declaration variables
        String userInput = "";
        double radius, rectangleLengthOne, rectangleLengthTwo, oneSide, secondSide, thirdSide;
        double cArea, cPerimeter, rArea, rPerimeter, tArea, tPerimeter;
        boolean proceed = true;

        //create scanner and call function to print welcome banner
        Scanner scan = new Scanner(System.in);
        printWelcome();
        Calculation c = new Calculation();

        //loop until the user wont put Q
        do{
            if(proceed) {
                //taking input from user
                System.out.print("Enter C for circle, R for rectangle, or T for triangle: ");
                userInput = scan.next().toUpperCase();
            }
                //match user input to proper shape and call functions which calculate area and perimeter
                //if user is putting input that its not number, it is catching exception
                try {
                    if (userInput.equals("C")) {
                        System.out.print("Enter the radius: ");
                        radius = scan.nextInt();
                        cArea = c.circleArea(radius);
                        cPerimeter = c.circlePerimeter(radius);
                        System.out.printf("The area of the circle is %.2f, and the circumference is %.2f.\n", cArea, cPerimeter);
                        proceed = true;
                    } else if (userInput.equals("R")) {
                        System.out.print("Enter the length and width: ");
                        rectangleLengthOne = scan.nextInt();
                        rectangleLengthTwo = scan.nextInt();
                        rArea = c.rectangleArea(rectangleLengthOne, rectangleLengthTwo);
                        rPerimeter = c.rectanglePerimeter(rectangleLengthOne, rectangleLengthTwo);
                        System.out.printf("The area of the rectangle is %.2f, and the perimeter is %.2f.\n", rArea, rPerimeter);
                        proceed = true;
                    } else if (userInput.equals("T")) {
                        System.out.print("Enter the lengths of three sides: ");
                        oneSide = scan.nextInt();
                        secondSide = scan.nextInt();
                        thirdSide = scan.nextInt();
                        tArea = c.triangleArea(oneSide, secondSide, thirdSide);
                        tPerimeter = c.trianglePerimeter(oneSide, secondSide, thirdSide);
                        System.out.printf("The area of the triangle is %.2f, and the perimeter is %.2f.\n", tArea, tPerimeter);
                        proceed = true;
                    } else if (userInput.equals("Q")) {
                        System.out.println("Thank you for using Shape Calculator!");
                        proceed = true;
                    } else {
                        System.out.println("That is not a recognized shape.");
                        proceed = true;
                    }
                }catch(Exception ex){
                System.out.println("You need to put only numbers.");
                scan.nextLine();
                proceed = false;
                }

        }while (!userInput.equals("Q"));



    }
}
