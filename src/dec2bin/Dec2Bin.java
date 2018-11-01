package dec2bin;

import java.util.Scanner;

/**
 * @author michi
 */
public class Dec2Bin {

    private static final String version = "1.0.1.57";

    /**
     * This method gets the number from the user
     *
     * @return int with number
     */
    private static int gettingNumber() {
        Scanner scanner = new Scanner(System.in);
        String pleaseEnterTxt = "Please enter a positive number that you would like to have converted: ";
        String input;

        int number;
        do {
            System.out.print(pleaseEnterTxt);
            while (!scanner.hasNextInt()) {
                input = scanner.next();

                switch (input) {
                    case "about":
                        System.out.println("--------------------------------------------------");
                        System.out.println("This tiny software was made for fun by Michael L.");
                        System.out.println("Version " + version);
                        System.out.println("For changelog: write 'changelog'");
                        System.out.println("--------------------------------------------------");
                        System.out.println(pleaseEnterTxt);
                        break;
                    case "changelog":
                        System.out.println("--------------------------------------------------");
                        System.out.println("New in Version " + version + ":");
                        System.out.println("- added changelog");
                        System.out.println("- added possibility to convert several numbers one after the other.");
                        System.out.println("--------------------------------------------------");
                        System.out.println(pleaseEnterTxt);
                        break;
                    default:
                        System.out.printf("\"%s\" is not a valid number. Try again:\n", input);
                        break;
                }
            }
            
            number = scanner.nextInt();
        } while (number < 0);

        return number;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Welcome
        System.out.println("Welcome to dec2Bin");

        // about
        System.out.println("For information about this software, write 'about'.");

        // Start procedure
        start();
    }

    private static void start() {
        // Create new calculator
        Calculator c = new Calculator();

        // The number
        int n;

        // "=" for clarity
        String breaks = "";
        
        // Get the number
        n = gettingNumber();

        // generate "calculating" - text
        String calcTxt = "Calculating the number " + n + "...";

        // Calculate how many "=" we need to fit to text
        for (int i = 0; i < calcTxt.length(); i++) {
            breaks += "=";
        }

        // Adding "=" for clarity
        System.out.println("\n" + breaks);

        // Writing calc Text
        System.out.println(calcTxt);

        // Adding "=" for clarity
        System.out.println(breaks);

        // Write calculated result
        System.out.println(c.calculate(n));

        // Rerun
        start();
    }
}
