/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dec2bin;

import org.evosuite.shaded.org.apache.commons.lang3.ArrayUtils;

import static java.lang.Math.round;

/**
 * * This class deals with computing decimal numbers to binary numbers.
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

        if (curr == null) {
            return "";
        }

        String result;
        String bcd;

        // binarys array for adding '0' or '1' as individual numbers
        char[] binaries = new char[curr];

        // for running through array
        byte i = 0;

        // run until calculating is finished
        while (curr != 0) {

            // If there is a remainder, then add a '1', otherwise a '0'
            binaries[i] = curr % 2 == 0 ? '0' : '1';

            // calculating
            curr = curr / 2;

            // setting iterator
            i++;
        }

        // Setting BCD
        bcd = this.showinBcd(i);

        // Reverse the array
        ArrayUtils.reverse(binaries);

        // setting result
        result = String.valueOf(binaries);

        result = result + "\n" + bcd;

        // return
        return result;
    }

    /**
     * This method shows the BCD (8421) numbers
     * @param resultLength - length of binary numbers
     * @return String with bcd numbers
     * TODO: need a space when binary is over 8 (1-2-4-8-16..)
     */
    private String showinBcd(int resultLength) {

        // init output
        StringBuilder output = new StringBuilder();

        // got to handle the 1 manually
        resultLength--;

        // move through result length
        for (int i = resultLength; i > 0 ; i--) {

            // append 2^i
            output.append(String.valueOf(round(Math.pow(2, i))));
        }

        // as i said, we got to handle the 1 manually
        output.append("1");

        // return output
        return output.toString();
    }
}
