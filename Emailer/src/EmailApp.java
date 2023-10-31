import java.util.ArrayList;
import java.util.Scanner;

public class EmailApp {
    public static void printWelcome(){
        System.out.println("*".repeat(80));
        System.out.printf("%51s\n","Emailer Version 1.0");
        System.out.println("*".repeat(80));
    }
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
        Scanner scan = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        ArrayList<Email> emails = new ArrayList<Email>();
        Email e;
        printWelcome();
        int userChoice=0,i=0;
        String receptions, subject,body,fileName;
        do {
            printMenu();
            try {
                userChoice = scan.nextInt();
            }catch (Exception c){
                System.out.println("You need to enter the number");
            }
            if(userChoice == 1){
                System.out.print("Enter recipients' email: ");
                receptions = s.nextLine();
                System.out.print("Enter subject: ");
                subject = s.nextLine();
                System.out.print("Enter body: ");
                body = s.nextLine();
                e = new Email(subject,body,false);
                e.setReceptions(receptions);
                emails.add(e);
            }else if(userChoice == 2){
                System.out.println();
                EmailPrinter.writeToScreen(emails);

            } else if(userChoice == 3){
                for (Email em : emails){
                    em.send();
                }
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
            }

        }while(userChoice != 5);
    }
}
