/*
 * Wiktoria Cioch-Gradzik
 * 10/19/2023
 * FA23-CPSC-24500-002
 * This program is taking the number of story and creating a new story with replaced words
 * from Array lists
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MadlibGame {
    private static ArrayList<String> adj, adv, pastVerb, pluNoun, pluVer, singNoun, singVerb;
    private static Random rnd;
    /**
     * This function is printing the welcome banner
     */
    public static void printWelcome() {
        System.out.println("*".repeat(65));
        System.out.printf("*%43s%21s\n", "Welcome to Madlibs V1.0", "*");
        System.out.println("*".repeat(65));
        System.out.println();
        System.out.println("This program generates random stories using wordlists you supply.");
        System.out.println();
    }
    /**
     * This function is declaring array Lists, which will hold values from text files
     */
    public static void createWordLists() {
        adj = new ArrayList<String>();
        adv = new ArrayList<String>();
        pastVerb = new ArrayList<String>();
        pluNoun = new ArrayList<String>();
        pluVer = new ArrayList<String>();
        singNoun = new ArrayList<String>();
        singVerb = new ArrayList<String>();
    }

    /**
     * This function is taking folder path and it is reading the line from text file and save it
     * as appropriate Array lists declared in createWordLists()
     * @param folder - String name of folder path
     * @return - boolean true if process was successful
     *                   false if process was unsuccessful
     */
    public static boolean loadWordLists(String folder) {
        //its creating new ArrayList, which is holding all ArrayLists declared in createWordLists()
        ArrayList<ArrayList<String>> allFolders = new ArrayList<ArrayList<String>>();
        //creating array list with String name of folders
        String[] name = {"adj.txt", "adv.txt", "pastverb.txt", "plunoun.txt", "pluverb.txt", "singnoun.txt", "singverb.txt"};
        boolean procced = true;
        Scanner sc;

        allFolders.add(adj);
        allFolders.add(adv);
        allFolders.add(pastVerb);
        allFolders.add(pluNoun);
        allFolders.add(pluVer);
        allFolders.add(singNoun);
        allFolders.add(singVerb);
        //its taking name of folder and its reading and saving lines of file in proper ArrayLists
        try {
            for (int i = 0; i < name.length; i++) {
                if(folder.equals("")) {
                    sc = new Scanner(new File(name[i]));
                }else {
                    sc = new Scanner(new File(folder, name[i]));
                }
                String line;
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                    allFolders.get(i).add(line);
                }
                sc.close();
            }
        } catch (Exception ex) {
            procced = false;
        }
        return procced;
    }

    /**
     * This function is taking name of folder and number of story.
     * It is reading and saving lines of file in Array List
     * @param folder - String name of folder
     * @param storyNum - int number of story
     * @return Array List result, which contains lines of file
     *         null - if process is unsuccessful
     */

    public static ArrayList<String> readStory(String folder, String storyNum) {
        //declaring Array List result, String line and Scanner
        ArrayList<String> result = new ArrayList<String>();
        String line;
        Scanner fsc;
        try {

            if(folder.equals("")) {
                fsc = new Scanner(new File( "story" + storyNum + ".txt"));
            }else {
                fsc = new Scanner(new File(folder, "story" + storyNum + ".txt"));
            }

            while (fsc.hasNextLine()) {
                line = fsc.nextLine();
                result.add(line);

            }
            fsc.close();
            return result;

        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * This function is taking elements of Array list and its searching for key words in Sting objects
     * It is taking random element of Array List, which contains list of words and switch it with key words
     * @param sto - Array List, which contains lines of story
     * @return sto - Array List with change words
     */
    public static ArrayList<String> tellStory(ArrayList<String> sto) {
        //declaring auxiliary variables that will hold a randomly generated word from list
        //create new random object
        String adjt, advt,pastV, pluN, pluV, singN, singV;
        String stor;
        rnd = new Random();
        //for loop is going through all elements in lists, generating random word and replacing
        //key word with new one
        for(int i = 0; i < sto.size(); i++) {
            stor = sto.get(i);
            while(stor.contains("<adj>")){
                adjt = adj.get(rnd.nextInt(adj.size()));
                stor = stor.replaceFirst("<adj>", adjt);
                sto.set (i, stor);
            }
            while(stor.contains("<adv>")){
                advt = adv.get(rnd.nextInt(adv.size()));
                stor = stor.replaceFirst("<adv>", advt);
                sto.set (i, stor);
            }
            while(stor.contains("<pastverb>")){
                pastV = pastVerb.get(rnd.nextInt(pastVerb.size()));
                stor = stor.replaceFirst("<pastverb>", pastV);
                sto.set (i, stor);
            }
            while(stor.contains("<plunoun>")){
                pluN = pluNoun.get(rnd.nextInt(pluNoun.size()));
                stor = stor.replaceFirst("<plunoun>", pluN);
                sto.set (i, stor);
            }
            while(stor.contains("<pluverb>")){
                pluV = pluVer.get(rnd.nextInt(pluVer.size()));
                stor = stor.replaceFirst("<pluverb>", pluV);
                sto.set (i, stor);
            }
            while(stor.contains("<singnoun>")){
                singN = singNoun.get(rnd.nextInt(singNoun.size()));
                stor = stor.replaceFirst("<singnoun>", singN);
                sto.set (i, stor);
            }
            while(stor.contains("<singverb>")){
                singV = singVerb.get(rnd.nextInt(singVerb.size()));
                stor = stor.replaceFirst("<singverb>", singV);
                sto.set (i, stor);
            }
        }

        return sto;
    }

    /**
     * Its printing elements of Array List
     * @param story- Array List which contains line of story
     */
    public static void printStory(ArrayList<String> story){
        for(String st: story){
            System.out.println(st);
        }
    }
    public static void main(String[] args){
        //declaring variables and new Scanner
        String folderPath;
        String storyNum;
        Scanner scan = new Scanner(System.in);
        printWelcome();
        createWordLists();
        System.out.println("Enter the name of the folder where the stories and wordlists are.");
        System.out.print("Or just press Enter to accept the default location: ");
        folderPath = scan.nextLine();
        System.out.println();
        //its executing if folder is not existing and it is finishing program
        if(!loadWordLists(folderPath)){
            System.out.println("There is an error with this folder path.");
            System. exit(0);
        }
        ArrayList<String> story;
        //creating do while loop, which is asking user about number of story and print a new story for user
        //its working until user type q or Q
        do {
            System.out.print("Enter a story number or q to quit: ");
            storyNum = scan.nextLine();
            System.out.println();
            if(!(storyNum.equals("q")|| storyNum.equals("Q"))) {
                story = readStory(folderPath, storyNum);
                if (story == null) {
                    System.out.println("That story does not exist. Choose again.");
                    System.out.println();
                }else{
                    System.out.println("Here is your Madlib:");
                    System.out.println();
                    printStory(tellStory(story));
                    System.out.println();




                }
            }

        }while(!(storyNum.equals("q") || storyNum.equals("Q")));
        System.out.println("Thank you for using this program. ");


    }
}
