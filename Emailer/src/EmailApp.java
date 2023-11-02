/*
 * Wiktoria Cioch-Gradzik
 * 10/30/2023
 * FA23-CPSC-24500-002
 * This program is taking a number. It is writing an email with format that provides user: recipients, subject, body.
 * It is printing email to screen and file and changing the send status.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class EmailApp {
    /**
     * This function is printing the welcome banner
     */
    public static void printWelcome(){
        System.out.println("*".repeat(80));
        System.out.printf("%51s\n","Emailer Version 1.0");
        System.out.println("*".repeat(80));
    }
    /**
     * This function is printing the menu
     */
    public static void printMenu(){
        System.out.println();
        System.out.println("Here are your choices:");
        System.out.println("1. Write email");
        System.out.println("2. List emails");
        System.out.println("3. Send emails");
        System.out.println("4. Save emails to file");
        System.out.println("5. Exit");
        System.out.print("Enter the number of your choice: ");
    }
    public static void main(String[] args){
        //it creates a scanner and ArrayList, which will contain Email objects
        Scanner scan;
        Scanner s = new Scanner(System.in);
        ArrayList<Email> emails = new ArrayList<Email>();
        Email e;
        printWelcome();
        int userChoice=0;
        String receptions, subject,body,fileName;
        //its creating a loop, which will print a menu and take the options from user until user wont enter 5
        //if user will enter wrong number or word program will show a proper message and give possibility to enter the choice again
        do {
            printMenu();
            scan = new Scanner(System.in);
            try {
                userChoice = scan.nextInt();

            }catch (Exception c){
                System.out.println("You need to enter the number");
                continue;
            }
            //its creating Email object with date provides from user
            if(userChoice == 1){
                System.out.print("Enter recipients' email: ");
                receptions = s.nextLine();
                System.out.print("Enter subject: ");
                subject = s.nextLine();
                System.out.print("Enter body: ");
                body = s.nextLine();
                e = new Email(subject,body,false,receptions);
                emails.add(e);
            //its calling the writeToScreen function
            }else if(userChoice == 2){
                System.out.println();
                EmailPrinter.writeToScreen(emails);
            //its changing email status to send
            } else if(userChoice == 3){
                for (Email em : emails){
                    em.send();
                }
                System.out.println("All emails have been sent.");
            //its calling to writeToFile function
            }else if(userChoice == 4){
                System.out.print("Enter the name of the file to save: ");
                fileName = s.nextLine();
                if (EmailPrinter.writeToFile(emails,fileName)){
                    System.out.println("Emails were saved successfully.");
                }else{
                    System.out.println("The procedure failed");
                }
            }else if(userChoice == 5){
                break;
            }else{
                System.out.println("Invalid number.");
                scan.reset();
            }

        }while(userChoice != 5);
        System.out.println();
        System.out.println("Thank you for using this program.");
    }
}
