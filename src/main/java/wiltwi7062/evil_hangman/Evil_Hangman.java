
package wiltwi7062.evil_hangman;

import java.io.FileNotFoundException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static wiltwi7062.evil_hangman.EvilHangmanKeyBuilder.Pattern;

/**
 *
 * @author wiltw
 */
public class Evil_Hangman extends FileHandler{

    public static void main(String[] args) {
        Random rand = new Random();
        boolean hasGuessleft;
        String currentFamily ="";
        int wordLength;
        int guesses;
        char guess;
        WordsDictionary devious = new WordsDictionary();
        Family current = new Family();
        Scanner scnr = new Scanner(System.in);
        System.out.println("how many characters would you like for a word");
        wordLength = scnr.nextInt();
        if (wordLength >= 26) {
            guesses = rand.nextInt(25,1);
            hasGuessleft = true;
        } else {
            guesses = wordLength -1;
            hasGuessleft = true;
        }
        ArrayList<String> wordsList = new ArrayList();
        try {
            wordsList = findWords(wordLength);
            if (wordsList.isEmpty()) {
                wordsList = findWords(4);
                guesses = 3;
                hasGuessleft = true;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Evil_Hangman.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Evil_Hangman.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (hasGuessleft) {
            System.out.println("enter a character for a guess");
            guess = scnr.next().charAt(0);
            for (int i=0;i<wordsList.size();i++) {
                if (devious.contains(Pattern(wordsList.get(i), guess, currentFamily))) {
                    Vector<String> v = new Vector<String>(Pattern(wordsList.get(i), guess, currentFamily));
                    
                    
                    
                }
            
            }
        }
        
        
    }
    
    public static WordsDictionary revampFamily (WordsDictionary current,String currentOutput) {
        String nextPattern;
    }
    
    public static Boolean guessChecker(int guessesleft) {
        if (guessesleft ==0) {
            return false;
        } else {
            return true;
        }
    }
    
    public static Family updateList(Family current, String newaddition) {
        current.add(newaddition);
        return current;
    }
    
    // need a method that handles guess logic
    
    public static char getGuess() {
        Scanner scnr = new Scanner(System.in);
        char result;
        System.out.println("please input a character");
        result = scnr.next().charAt(0);
        return result;
    }
    public static void updatePlayer(String goal) { // this will be used when i introduce the gui.
//        for (int i=0;i<goal.length();i++) implement this code when gui comes around
//            Jfield(i) = goal.charAt(i);
        System.out.println(goal);
    }
    
    
    
    
    
    
}
