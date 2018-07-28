/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dec2bin;

import java.util.Scanner;

/**
 * @author michi
 */
public class Dec2Bin {

    /**
     * This method gets the number from the user
     * @return int with number
     */
    private static int gettingNumber() {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.print("Please enter a positive number that you would like to have converted: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number. Try again:\n", input);
            }
            number = scanner.nextInt();
        } while (number < 0);

        return number;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create new calculator
        Calculator c = new Calculator();

        // for the number
        int n;

        // "=" for clarity
        String breaks = "";

        // Welcome
        System.out.println("Welcome to dec2Bin");

        // Get the number
        n = gettingNumber();

        // generate "calculating" - text
        String calcTxt = "Calculating the number " + n + "...";

        // calculate how many "=" we need to fit to text
        for (int i = 0; i < calcTxt.length(); i++) {
            breaks += "=";
        }

        // adding "=" for clarity
        System.out.println("\n" + breaks);

        // writing calc Text
        System.out.println(calcTxt);

        // adding "=" for clarity
        System.out.println(breaks);

        // write calculated result
        System.out.println(c.calculate(n));

        // prevent from closing :O
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
