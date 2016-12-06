/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.alternatingSplit;

import java.util.Scanner;

/**
 *
 * @author chira
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text;
        int level,choice;
           
        System.out.println("Welcome to Alternate Split (Simple Encryptor)");
        System.out.println("1.Encrypt");
        System.out.println("2.Decrypt");
        System.out.println("3.Exit");
        System.out.println("Enter an option [1-3]");
        choice = input.nextInt();
        switch(choice){
            case 1:
            {
                System.out.println("Enter text to encrypt");
                 text = input.nextLine();
                text = input.nextLine();
                System.out.println("Enter level of encryption");
                level = input.nextInt();
                System.out.println(encrypt(text,level));
                break;
            }
            case 2:
            {
                System.out.println("Enter text to decrypt");
                 text = input.nextLine();
                text = input.nextLine();
                System.out.println("Enter level of encryption");
                level = input.nextInt();
                System.out.println(decrypt(text,level));
                break;
            }
            default:
                System.exit(0);
        }

    }

    public static String decrypt(String encryptedText, int n) {
        String decryptedText = "";
        String given = encryptedText;
        int length, j = 0;

        if (n <= 0 || encryptedText == null) {                                           //Does not waste time going through the process if n <= 0 or text given is null
            return encryptedText;
        }

        for (int k = 0; k < n; k++) {

            String[] split = given.split("");                                            //Splits the string and puts it in array
            length = split.length;
            j = 0;                                                                       //Recalibrates j to 0 for next round of decryption if needed
            for (int i = (length / 2); i < length; i++) {
                decryptedText += split[i];
                if (j < length / 2) {                                                    //Condition prevents repition of letters
                    decryptedText += split[j];
                    j += 1;
                }
            }
            given = decryptedText;                                                        //variable stores the decrypted text for carrying out spltting into array for next round of decryption
            decryptedText = "";                                                           //recalibrates to empty for next round

        }
        return given;
    }

    public static String encrypt(final String text, final int n) {
        String encryptedText = "";
        String given = text;
        if (n <= 0 || text == null) {                    //Does not waste time going through the process if n <= 0 or text given is null
            return text;
        }

        for (int j = 0; j < n; j++) {                    //Determines times encrypted

            String[] split = given.split("");            //Splits the string into characters and puts in array

            for (int i = 1; i < split.length; i++){      //Formula for alternate splitting (Encryption Process)
                encryptedText = encryptedText + split[i];
                i += 1;
            }
            for (int i = 0; i < split.length; i++) {
                encryptedText = encryptedText + split[i];
                i += 1;
            }

            given = encryptedText;                        //Recalibrates for next round
            encryptedText = "";                           //Recalibrates for next round
        }

        return given;

    }
}
