
package wiltwi7062.evil_hangman;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wiltw
 */
public class Evil_Hangman extends FileHandler{

    public static void main(String[] args) {
        String cuurentFamily ="";
        int wordLength;
        int guesses;
        Scanner scnr = new Scanner(System.in);
        System.out.println("how many characters would you like for a word");
        wordLength = scnr.nextInt();
        if (wordLength >= 26) {
            guesses = 25;
        } else {
            guesses = wordLength -1;
        }
        ArrayList<String> wordsList = new ArrayList();
        try {
            wordsList = findWords(wordLength);
        } catch (InterruptedException ex) {
            Logger.getLogger(Evil_Hangman.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Evil_Hangman.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    private String findFamily(String str, Character ch) {
        String temp ="";
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == ch) {
                temp += "1";
            } else {
                temp += "0";
            }
        }
        return temp;
    }
    Public String translateWord(String str, Character ch) {
        int i = 0;
        switch()
    }
    
    
}
