package dec2bin;

import static java.lang.Math.round;

/**
 * This class covers the conversion of decimal numbers to binary numbers.
 *
 * @author Michael Lucas
 */
class Calculator {

    /**
     * Calculates the binary number.
     *
     * @return String with calculated binary number
     */
    String calculate(Integer number) {

        // NULL check
        if (number == null) {
            return "Sorry, this number is invalid.";
        }

        int
                length;

        byte
                i = 0;

        StringBuilder
                breaks = new StringBuilder(),
                normal = new StringBuilder(),
                formatted = new StringBuilder();
        String
                bcd;

        // Run until the calculations are complete
        while (number != 0) {

            // If there is a remainder, then add a '1', otherwise a '0'
            formatted.append(number % 2 == 0 ? " 0" : " 1");
            normal.append(number % 2 == 0 ? "0" : "1");

            // Adding spaces
            // Formula: 2^i
            // (e.g.) 2^5   = 32  => 2 digits, so add 1 space
            // 2nd e.g. 2^9 = 512 => 3 digits, so add 2 spaces
            for (int j = 0; j < String.valueOf(round(Math.pow(2, i))).length() - 1; j++) {
                formatted.append(" ");
            }

            number /= 2;
            i++;
        }

        bcd = this.showinBcd(i);

        // Reversing the array
        formatted = reverse(formatted.toString());
        normal = reverse(normal.toString());

        // Calculating clarity
        length = bcd.length() > "Formatted spelling:".length()
                ? bcd.length()
                : "Formatted spelling:".length();

        for (int j = 0; j < length; j++) {
            breaks.append("-");
        }

        // Adding clarity
        normal = new StringBuilder("Normal spelling:\n" + normal + "\n" + breaks);

        // Adding clarity and bcd
        formatted.insert(0, breaks + "\nFormatted spelling:\n");
        formatted.append("\n").append(bcd).append("\n").append(breaks);

        return formatted + "\n" + normal;
    }

    /**
     * Reverses the passed string
     *
     * @param toReverse - The passed string
     * @return - The reversed string
     */
    private StringBuilder reverse(String toReverse) {
        assert toReverse != null;
        return new StringBuilder(new StringBuffer(toReverse).reverse().toString());
    }

    /**
     * Displays the BCD numbers
     *
     * @param resultLength - length of binary numbers
     * @return String with bcd numbers
     */
    private String showinBcd(int resultLength) {
        assert resultLength >= 0;
        StringBuilder output = new StringBuilder();

        // Got to handle the 1 manually
        resultLength--;

        for (int i = resultLength; i > 0; i--) {
            // Append 2^i
            output.append(String.valueOf(round(Math.pow(2, i)) + "-"));
        }

        // Handle the 1 manually
        output.append("1 ");

        return output.toString();
    }
}
