import java.io.File;
import java.util.Scanner;
import java.util.Filel;

public class MadlibGame {
    public static void  printWelcome(){
        System.out.println("*".repeat(65));
        System.out.printf("*%43s%21s\n", "Welcome to Madlibs V1.0","*");
        System.out.println("*".repeat(65));
        System.out.println();
    }
    public static String readFile(String fname){
        try{
            String allText = "";
            Scanner text = new Scanner(new File(fname));
            String line;
            while (text.hasNextLine()){
                line = text.nextLine();
                allText = allText + line + " ";
            }
            text.close();
            return allText;
        }catch (Exception ex){
            return null;
        }
    }
    public static void main(String[] args){
        printWelcome();
        System.out.println("This program generates random stories using wordlists you supply.");

    }
}
