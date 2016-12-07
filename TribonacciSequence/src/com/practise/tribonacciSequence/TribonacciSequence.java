package com.practise.tribonacciSequence;

import java.util.Scanner;

/**
 *
 * @author chirag
 */
public class TribonacciSequence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c;
        int n;
        System.out.println("Welcome to Tribonacci Sequence Generator");
        System.out.println("Enter Signature (First three elements and number of elements for the sequence separated by a space)");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        n = input.nextInt();

        double[] array = {a, b, c};
        double[] array1 = tribonacci(array, n); //Calls the function that creates the sequence and returns the array of it

        for (int i = 0; i < 10; i++) {
            System.out.println(array1[i]);      //Prints out the Sequence
        }
    }

    public static double[] tribonacci(double[] s, int n) {
        double[] array = new double[n];         //Initializes array according to size given

        if (n == 0 || s.length != 3 || n < 0) { //Checks for invalid inputs
            return array;
        }
        if (n == 1) {                           //Special Case 1
            array[0] = s[0];
            return array;
        }
        if (n == 2) {                           //Special Case 2
            array[0] = s[0];
            array[1] = s[1];
            return array;
        }

        array[0] = s[0];                        //Normal Case -- Here to bottom
        array[1] = s[1];
        array[2] = s[2];

        for (int i = 3; i < n; i++) {           //Process for Tribonacci Sequence
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }

        return array;
    }

}
