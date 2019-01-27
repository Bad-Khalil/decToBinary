package dec2bin;

import java.util.Scanner;

/**
 * @author michi
 */
public class Dec2Bin {

    private static final String version = "1.0.1.59";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to dec2Bin");
        System.out.println("For information about this software, write 'about'.");
        run();
    }

    /**
     * This method lets the user enter numbers to use them in "run".
     * It also checks if valid numbers have been entered.
     *
     * @return int with number
     */
    private static int gettingNumber() {
        Scanner scanner = new Scanner(System.in);
        String
                pleaseEnterTxt = "Please enter a positive number that you would like to have converted: ",
                input;

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
                        System.out.println("- improved Code");
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

    private static void run() {
        Calculator
                calc = new Calculator();

        int
                number = gettingNumber();

        StringBuilder
                breaks = new StringBuilder();
        String
                calcTxt = "Calculating the number " + number + "...";

        // Calculate how many "=" we need to fit the text
        for (int i = 0; i < calcTxt.length(); i++) {
            breaks.append("=");
        }

        // Adding "=" for clarity
        System.out.println("\n" + breaks);
        System.out.println(calcTxt);

        // Adding "=" for clarity
        System.out.println(breaks);

        // Write calculated result
        System.out.println(calc.calculate(number));

        // Rerun
        run();
    }
}
