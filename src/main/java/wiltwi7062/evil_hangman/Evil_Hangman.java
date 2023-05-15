
package wiltwi7062.evil_hangman;

import java.io.FileNotFoundException;
import java.lang.String;
import  wiltwi7062.evil_hangman.Family;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
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
        currentFamily = wordCreator(wordLength);
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
//        while (hasGuessleft) {
//          while(!devious.isEmpty()) {
//          
//        
//               
//           }         
//        }            
//                   proposed game logic while guesschecker meaning while guesses are >0
//  take user char run the pattern on current Families stored in the current words dictionary
//                    update the words dictionary to reflect the new choices pick the Family with the greates members and display that hint to the player
// the game ends when the dictionary runs out of usable families(families greater than 0) or numguesses hits 0
//                }
//            
//            }
//        }
        
        
    }
    
    public static WordsDictionary revampFamily (WordsDictionary treeMap,String currentOutput, char currentGuess) { // this will update the current working dictionary
        String nextPattern, temp;
        int counter, index, maxCount;
        Family tempAL = new Family();
        WordsDictionary tempdic = new WordsDictionary();
        Set<Map.Entry<String, Family>> entrySet = (treeMap.entrySet());
        index = 0;
        for(Map.Entry<String, Family> currentEntry : entrySet) {
            temp = currentEntry.getKey();
            tempAL = currentEntry.getValue();
            for (int i=0;i<tempAL.getLength();i++) {
                
            }
            
            
        }
        return tempdic;
    }
    public static boolean ismatching(String a, String b) {   // this will be a bounding method assisting our game logic
        for (int i=0; i<a.length();i++) {
            if (a.charAt(i) != b.charAt(i)){
                return false;
            }else {
                
            }
        }
        return true;
    }
    
    public static boolean isFamilyRelated(String pattern, String comparison) {   //this will be the primary bounding method
        for (int i=0;i<pattern.length();i++) {
            if (pattern.charAt(i)=='1') {
                i++;
            } else if (pattern.charAt(i) != comparison.charAt(i)) {
                return false;
            } else {
                
            }
        }
        return true;
    }
            
    
    public static Boolean guessChecker(int guessesleft) {
        if (guessesleft ==0) {
            return false;
        } else {
            return true;
        }
    }
    
    public static String wordCreator(int wordlength) {
        String temp = "";
        for (int i=0;i<wordlength;i++) {
            temp = temp + '1';
        }
        return temp;
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
