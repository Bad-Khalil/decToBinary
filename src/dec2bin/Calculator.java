package dec2bin;
import static java.lang.Math.round;

/**
 * This class deals with computing decimal numbers to binary numbers.
 *
 * @author michi
 */
class Calculator {

    /**
     * Calculates the binary number
     *
     * @return String with calculated binary number
     */
    String calculate(Integer curr) {

        // null check
        if (curr == null) {
            return "Sorry, this number is invalid.";
        }

        // Is used for adding clarity ("-")
        int laenge;

        // Is used for adding clarity ("-")
        StringBuilder breaks = new StringBuilder();

        // Is used for the bcd output
        String bcd;

        // We got 2 output Strings.
        // Formatted eg   1  1 1 0 1 1
        StringBuilder formatted = new StringBuilder();

        // Normal eg 111011
        StringBuilder normal = new StringBuilder();

        // For running through array
        byte i = 0;

        // run until calculating is finished
        while (curr != 0) {

            // If there is a remainder, then add a '1', otherwise a '0'
            formatted.append(curr % 2 == 0 ? " 0" : " 1");
            normal.append(curr % 2 == 0 ? "0" : "1");

            // Adding spaces
            // Formula: 2^i
            // (e.g.) 2^5   = 32  => 2 digits, so add 1 space
            // 2nd e.g. 2^9 = 512 => 3 digits, so add 2 spaces
            for (int j = 0; j < String.valueOf(round(Math.pow(2,i))).length() - 1; j++) {
                formatted.append(" ");
            }
            // Calculating
            curr = curr / 2;

            // Setting iterator
            i++;
        }

        // Setting BCD
        bcd = this.showinBcd(i);

        // Reversing the array
        formatted = new StringBuilder(new StringBuffer(formatted.toString()).reverse().toString());
        normal = new StringBuilder(new StringBuffer(normal.toString()).reverse().toString());

        // Calculating clarity
        laenge = bcd.length() > "Formatted spelling:".length() ? bcd.length() : "Formatted spelling:".length();
        for (int j = 0; j < laenge; j++) {
            breaks.append("-");
        }

        // Adding clarity
        normal = new StringBuilder("Normal spelling:\n" + normal + "\n" + breaks);

        // Adding clarity and bcd
        formatted.insert(0, breaks + "\nFormatted spelling:\n");
        formatted.append("\n").append(bcd).append("\n").append(breaks);

        // Return
        return formatted + "\n" + normal;
    }

    /**
     * This method shows the BCD (8421) numbers
     * @param resultLength - length of binary numbers
     * @return String with bcd numbers
     */
    private String showinBcd(int resultLength) {

        // Init output
        StringBuilder output = new StringBuilder();

        // Got to handle the 1 manually
        resultLength--;

        // Move through result length
        for (int i = resultLength; i > 0 ; i--) {

            // Append 2^i
            output.append(String.valueOf(round(Math.pow(2, i)) + "-"));
        }

        // As i said, we got to handle the 1 manually
        output.append("1 ");

        // Return output
        return output.toString();
    }
}
