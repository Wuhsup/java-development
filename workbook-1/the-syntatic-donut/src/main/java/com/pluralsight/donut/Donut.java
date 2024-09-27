package com.pluralsight.donut;
// We LOVE our delimiters!!!
// We LIKE our indentation!!
// We use upper and lower case because we should ...
/*
 *  { }   Curly braces
 *        Surround:
 *          Method body
 *          Class declaration
 *          Array initializer
 *  [ ]   Square brackets
 *          Array declarations
 *          Array access
 *  < >   Pointy brackets
 *          Template parameter lists
 *  ( )   Parentheses
 *          Parameter list for a method
 *  ;     Semicolon
 *          Ends a statement
 */
import java.util.Scanner;
public class Donut {
    static double price = .25;
    public static double getTotalPrice(int numberOfDonuts ) {
        return price * numberOfDonuts;
    }
    public static void main(String[] args) {
        // Get a scanner to read input from System.in
        Scanner inputScanner = new Scanner(System.in);
        // Prompt the user for a number
        System.out.print("Welcome!  How many donuts do you want? :");
        // Read the input number
        int numberOfDonuts = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.println("Your donuts cost:");
        // Calculate the price
        double totalPrice = getTotalPrice(numberOfDonuts);
        // Print it out
        System.out.println( totalPrice + " dollars" );
        // Make it pretty
        System.out.printf("In dollars, that would be $%8.2f\n", totalPrice );
        // Print out a fun Math fact
        System.out.printf("The square root of 5 is %8.15f\n", Math.sqrt(5.0));
    }
}