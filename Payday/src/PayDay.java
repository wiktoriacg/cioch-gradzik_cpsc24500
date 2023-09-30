import java.util.Random;
import java.util.Scanner;
/*
 Wiktoria Cioch-Gradzik
 09/18/2023
 FA23-CPSC-24500-002
 This program is taking amount of work hours and hourly pay rate
 It is counting the net pay after subtracking tax and all additional costs.

 */

public class PayDay {
    public static void main(String[] args){
        //declaring variables
        String name, unionMember;
        double workHours, payRateHourly, savingAccount, grossPay, unionDues;
        double medDeduction, taxes, netPay,incidentPay;
        workHours = 0;
        payRateHourly = 0;
        savingAccount = 0;
        unionMember = "0";

        //create new Scanner and new Random
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        //its picking random incident Pay and display welcom banner
        incidentPay = -200.0 + 400*rand.nextDouble();
        System.out.println("************************************************");
        System.out.printf("%-18s%-20s\n"," ","Payday V1.0");
        System.out.println("************************************************");
        System.out.println();
        // its taking all input from user
        boolean condition = true;
        System.out.print("Enter name: ");
        name = scan.nextLine();
        while(condition) {
            Scanner sc = new Scanner(System.in);
            if(condition = true) {
                try {
                    System.out.print("Enter hours worked: ");
                    workHours = sc.nextDouble();
                    condition = false;
                } catch (Exception c) {
                    System.out.println("I am sorry your input its not in good format. You have to write number");
                }
            }
        }
        condition = true;
        while(condition) {
            Scanner sc = new Scanner(System.in);
            if(condition = true) {
                try {
                    System.out.print("Enter hourly pay rate: ");
                    payRateHourly = sc.nextDouble();
                    condition = false;
                } catch (Exception c) {
                    System.out.println("I am sorry your input its not in good format. You have to write number");
                }
            }
        }
        while (!(unionMember.equals("y") || unionMember.equals("n"))){
            System.out.print("Are you a union member (y or n)? ");
            unionMember = scan.next().trim().toLowerCase();
        }
        condition = true;
        while(condition) {
            Scanner sc = new Scanner(System.in);
            if(condition = true) {
                try {
                    System.out.print("What percentage do you want to withould for your medical savings account? ");
                    savingAccount = sc.nextDouble();
                    if(savingAccount> 100 || savingAccount <0){
                        System.out.println("You can only put percent from 0 to 100");
                    }else {
                        condition = false;
                    }
                } catch (Exception c) {
                    System.out.println("I am sorry your input its not in good format. You have to write number");
                }
            }
        }
        //counting gross Pay and counting optional union Dues
        grossPay = workHours*payRateHourly;
        if(unionMember.equals("y")){
            unionDues = grossPay* 0.05;
        }else{
            unionDues = 0;
        }
        medDeduction = grossPay*savingAccount*0.01;
        //create new variable restPay and its counting good taxes
        double restPay = grossPay- unionDues;
        restPay = restPay-medDeduction;
        restPay = restPay + incidentPay;
        if(restPay>= 2500){
            taxes =restPay*0.25;
        } else if (restPay>= 1500) {
            taxes =restPay*0.15;
        }else if (restPay>= 500) {
            taxes =restPay*0.1;
        }else {
            taxes = restPay*0.05;
        }
        //display message to user
        netPay = grossPay-unionDues-medDeduction+incidentPay-taxes;
        System.out.println();
        System.out.println("---------PAYCHECK---------");
        System.out.printf("%-15s%1s%8.2f\n","Gross Pay","$",grossPay);
        System.out.printf("%-15s%1s%8.2f\n","Union Dues","$",unionDues);
        System.out.printf("%-15s%1s%8.2f\n","Med Deduction","$",medDeduction);
        System.out.printf("%-15s%1s%8.2f\n","Incident Pay","$",incidentPay);
        System.out.printf("%-15s%1s%8.2f\n","Tax","$",taxes);
        System.out.printf("%-15s%1s%8.2f\n","Net Pay","$",netPay);
        System.out.println("--------------------------");
        System.out.println("Prepared for "+name);
        System.out.println();
        System.out.println("Thank you for using this program.");



    }
}
