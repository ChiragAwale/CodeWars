/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.arrayComparer;

import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Program {

    /**
     * This program checks if all elements have their squared values in the second array
     *
Description:

Given two arrays a and b write a function comp(a, b) (compSame(a, b) in Clojure) that checks whether the two arrays have the "same" elements, with the same multiplicities. "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.

Examples

Valid arrays

a = [121, 144, 19, 161, 19, 144, 19, 11]  
b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144, 361 the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of squares:

a = [121, 144, 19, 161, 19, 144, 19, 11] 
b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
Invalid arrays

If we change the first number to something else, comp may not return true anymore:

a = [121, 144, 19, 161, 19, 144, 19, 11]  
b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
comp(a,b) returns false because in b 132 is not the square of any number of a.

a = [121, 144, 19, 161, 19, 144, 19, 11]  
b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]
comp(a,b) returns false because in b 36100 is not the square of any number of a.

Remarks

a or b might be [] (all languages). a or b might be nil or null or None (except in Haskell, Elixir, C++).

If a or b are nil (or null or None), the problem doesn't make sense so return false.

If a or b are empty the result is evident by itself.

Note for C

The two arrays have the same size (> 0) given as parameter in function comp.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size1 = 0;
        int size2 = 0;
        
        System.out.println("Enter size of first array");                        //Asks size for first array
        size1 = input.nextInt();
        int [] a = new int[size1];
        
        System.out.println("Enter values for first array");                     //Asks values for first array
        for(int i=0;i<size1;i++){
          a[i] =  input.nextInt();
        }
        System.out.println("Enter size of second array");                       //Asks size for second array
        size2 = input.nextInt();        
        int [] b = new int[size2];
        
        System.out.println("Enter values for second array");                    //Asks values for second array
        for(int i=0;i<size2;i++){
          b[i] =  input.nextInt();
        }
        
        if(areSame(a,b)){                                                       //Calls the function to check the arrays and displays accordingly
            System.out.println("True");
        }else{
            System.out.println("Not true");
        }
        
    }
    
     public static boolean areSame(int[] a, int[] b) {
        int sizeA = 0;
        int sizeB = 0;
        int count = 0;                                                          //Variable used for checking if all the elements of first array have their square in the other array                         

        //Checks if the arrays are null and returns false if found to be null
        if (a == null || b == null) {
            return false;
        } else {
            //If and only if the arrays are not null then the sizes are calculated(to prevent NullPointerException)
            sizeA = a.length;
            sizeB = b.length;

        }

        if (sizeA == sizeB) {                                                   //If size of both array is not same, all elements of first array cannot have their squares in the second array

            for (int i = 0; i < sizeA; i++) {
                for (int j = 0; j < sizeB; j++) {
                    if ((Math.pow(a[i], 2)) == b[j]) {                          //Checks for the square of elements of first array in the second
                        count = count + 1;
                        b[j] = -1;                                              //changes the value in first array after finding its square to prevent double checking of same element
                    }

                }
            }
            if (count == sizeA) {                                               //If squared values of all elements in first array has been found in the second array, returns true 
                return true;
            }
        }
        return false;                                                          
    }
}

    

