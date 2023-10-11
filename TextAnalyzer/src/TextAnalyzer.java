import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
/*
Wiktoria Cioch-Gradzik
10/07/2023
FA23-CPSC-24500-002
This program is reading a file ,and it is giving number of vowels,consonants,words.
This program is taking a name of file and write summary.
 */

public class TextAnalyzer {
    /**
     * This function is printing the welcome banner
     */
    public static void  printWelcome(){
        System.out.println("*".repeat(80));
        System.out.printf("%54s\n", "Welcome to TextAnalyzer V1.0");
        System.out.println("*".repeat(80));
        System.out.println();
    }
    /**
     * This function is printing the menu
     */
    public static void  printMenu(){
        System.out.println();
        System.out.println("Here are your options:");
        System.out.println("1. Count the number of vowels.");
        System.out.println("2. Count the number of consonants.");
        System.out.println("3. Count the number of words");
        System.out.println("4. Print a summary to a file.");
        System.out.println("5. Quit");
        System.out.print("Enter the number of your choice: ");
    }

    /**
     * This function is checking if file is existing and changes the contents of the file to String
     * @param fname- name of the file
     * @return allText - content of the file changed to String
     *         null - when the file is not found
     */
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

    /**
     * This function is counting number of vowels in String
     * @param file - String of content of file
     * @return count - number of vowels
     */
    public static int countVowels(String file){
        int count=0;
        file = file.toLowerCase();
        for (int i = 0; i< file.length(); i++) {
            if (file.charAt(i) == 'a'||file.charAt(i) == 'e'||file.charAt(i) == 'i'||file.charAt(i) == 'o'||file.charAt(i) == 'u'){
                count++;
            }
        }
        return count;
    }

    /**
     * This function is counting number of consonants in String
     * @param file - String of content of file
     * @return con - number of consonants
     */
    public static int countConsonants(String file){
        int charInt,con;
        int ch =0;
        for (int i = 0; i< file.length(); i++) {
            charInt = file.charAt(i);
            if((charInt>=65 && charInt<=90)||(charInt>=97 && charInt<=122)){
                ch++;
            }
        }
        con = ch - countVowels(file);
        return con;
    }
    /**
     * This function is counting number of Words in String
     * @param file - String of content of file
     * @return count - number of words
     */
    public static int countWords(String file){
        String [] words = file.split(" ");
        return words.length;
    }

    /**
     * This program is writing a file with summary
     * @param fileName - name of the file
     * @param textToAnalyze - String of content of file
     * @return true - if function was able to write file
     *         false - if function was not able to write file
     */
    public static boolean writeSummaryToFile(String fileName, String textToAnalyze){
        try {
            int vowels,consonants, words;
            vowels = countVowels(textToAnalyze);
            consonants = countConsonants(textToAnalyze);
            words = countWords(textToAnalyze);
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
            pw.println(("This is the text: "));
            pw.println(textToAnalyze);
            pw.println();
            pw.printf("There are %d vowels, %d consonants, and %d words.",vowels,consonants,words);
            pw.close();
            return true;
        }catch (Exception ex){
            System.out.println("There was a problem accessing to file.");
            return false;
        }
    }
    public static void main(String[] args){
        //declaration of variables
        String userFileName, file,writingFile;
        int choice = 0;
        int vowels,words,consonants;
        //create scanner and call print Welcome banner
        Scanner scan = new Scanner(System.in);
        printWelcome();
        //create loop which is working until user will not put proper name of file
        do{
            System.out.print("What text file would you like to analyze? ");
            userFileName = scan.nextLine();
            file = readFile(userFileName);
            System.out.println();
            if(file == null){
                System.out.println("There was a problem accessing to file.");
            }

        }while (file == null);
        //create loop which is working until user will not put 5
        //taking the users choice, use proper function and print result
        do{
            try{
                Scanner sc = new Scanner(System.in);
                printMenu();
                choice = sc.nextInt();
                if(choice>5 || choice<1){
                    System.out.println("That is not a valid choice.");
                }else if(choice == 1){
                    vowels = countVowels(file);
                    System.out.printf("There are %d vowels.\n", vowels);
                }else if(choice == 2){
                    consonants = countConsonants(file);
                    System.out.printf("There are %d consonants.\n", consonants);
                }else if(choice == 3){
                    words = countWords(file);
                    System.out.printf("There are %d words.\n", words);
                }else if(choice == 4){
                    Scanner s = new Scanner(System.in);
                    System.out.print("Enter the name of the file to write the summary: ");
                    writingFile = s.nextLine();
                    if(writeSummaryToFile(writingFile,file)){
                        System.out.println("The summary was written to a file.");
                    }else{
                        System.out.println("Writing a summary failed.");
                    }



                }
            }catch(Exception ex){
                System.out.println("You have to enter the number of your choice. You didn't type a number.");
            }


        }while(choice != 5);
        System.out.println();
        System.out.println("Thank you for using this program.");

    }
}
