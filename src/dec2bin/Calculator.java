/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

        // is used for adding clarity ("-")
        int laenge;

        // is used for adding clarity ("-")
        String breaks = "";

        // is used for the bcd output
        String bcd;

        // we got 2 output Strings.
        // formatted eg   1  1 1 0 1 1
        String formatted = "";

        // normal eg 111011
        String normal = "";

        // for running through array
        byte i = 0;

        // run until calculating is finished
        while (curr != 0) {

            // If there is a remainder, then add a '1', otherwise a '0'
            formatted += curr % 2 == 0 ? " 0" : " 1";
            normal += curr % 2 == 0 ? "0" : "1";

            // adding spaces
            // formula: 2^i
            // (e.g.) 2^5   = 32  => 2 digits, so add 1 space
            // 2nd e.g. 2^9 = 512 => 3 digits, so add 2 spaces
            for (int j = 0; j < String.valueOf(round(Math.pow(2,i))).length() - 1; j++) {
                formatted += " ";
            }
            // calculating
            curr = curr / 2;

            // setting iterator
            i++;
        }

        // Setting BCD
        bcd = this.showinBcd(i);

        // Reverse the array
        formatted = new StringBuffer(formatted).reverse().toString();
        normal = new StringBuffer(normal).reverse().toString();

        // if the length is greater than txt, then use length
        laenge = normal.length() > "Normal spelling:".length() ? normal.length() : "Normal spelling:".length();

        // adding clarity
        for (int j = 0; j < laenge; j++) {
            breaks += "-";
        }

        // adding clarity
        normal = breaks + "\nNormal spelling:\n" + normal + "\n" + breaks;
        laenge = bcd.length() > "Formatted spelling:".length() ? bcd.length() : "Formatted spelling:".length();
        breaks = "";
        for (int j = 0; j < laenge; j++) {
            breaks += "-";
        }

        //  // adding clarity and bcd
        formatted = breaks + "\nFormatted spelling:\n" + formatted;
        formatted = formatted + "\n" + bcd + "\n" + breaks;

        // return
        return formatted + "\n\n" + normal;
    }

    /**
     * This method shows the BCD (8421) numbers
     * @param resultLength - length of binary numbers
     * @return String with bcd numbers
     */
    private String showinBcd(int resultLength) {

        // init output
        StringBuilder output = new StringBuilder();

        // got to handle the 1 manually
        resultLength--;

        // move through result length
        for (int i = resultLength; i > 0 ; i--) {

            // append 2^i
            output.append(String.valueOf(round(Math.pow(2, i)) + "-"));
        }

        // as i said, we got to handle the 1 manually
        output.append("1 ");

        // return output
        return output.toString();
    }
}
