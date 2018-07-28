/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dec2bin;

import org.evosuite.shaded.org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author michi
 */
class Calculator {

    /**
     * Calculates the binary number
     * @return
     */
    String calculate(Integer curr){

        if (curr == null){
            return "";
        }

        // binarys array for adding '0' or '1' as individual numbers
        char[] binaries = new char[curr];

        // for running through array
        byte i = 0;

        // run until calculating is finished
        while (curr != 0){

            // If there is a remainder, then add a '1', otherwise a '0'
            binaries[i] = curr % 2 == 0 ? '0' : '1';

            // calculating
            curr = curr / 2;

            // setting iterator
            i++;
        }

        // Reverse the array
        ArrayUtils.reverse(binaries);

        // return
        return String.valueOf(binaries);
    }
}
