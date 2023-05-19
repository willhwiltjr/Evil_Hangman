
package wiltwi7062.evil_hangman;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
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
        Scanner scnr = new Scanner(System.in);   
        boolean hasGuessleft = false, hasWon = false;
        String currentFamily ="";
        int wordLength = 0, guesses = 0;
        char guess = 'a';
        WordsDictionary devious = new WordsDictionary();
        WordsDictionary tempdic = new WordsDictionary();
        gameLogic(guesses, hasWon, hasGuessleft, currentFamily, tempdic, devious, guess, wordLength, scnr, rand);
    }
    
    public static WordsDictionary revampFamily (WordsDictionary treeMap,String currentOutput, char currentGuess) { // this will update the current working dictionary
        String  temp, loopTemp, loopTempActual;
        Family tempAL = new Family();
        WordsDictionary tempdic = new WordsDictionary();
        Set<Map.Entry<String, Family>> entrySet = (treeMap.entrySet());
        for(Map.Entry<String, Family> currentEntry : entrySet) {
            temp = currentEntry.getKey();
            tempAL = currentEntry.getValue();
            Iterator<String> familyiterator = tempAL.iterator();
            while (familyiterator.hasNext()) {
                loopTempActual = (String)familyiterator.next();
               loopTemp = Pattern(loopTempActual, currentGuess, temp);
               if (isFamilyRelated(loopTemp, loopTempActual)){
                tempdic = tempdic.AppendDic(tempdic, loopTempActual,loopTemp);
               } 
                   
               
            }
            
            
        }
        return tempdic;
    }
    
    
    public static String isBiggestFamily(WordsDictionary treeMap,String currentPattern) {
        WordsDictionary tempdic = treeMap;
        String tempStr = "";
        int countermost=0;
        Family tempAL = new Family();
        
        Set<Map.Entry<String, Family>> entrySet = (tempdic.entrySet());
        for (Map.Entry<String, Family> currentEntry : entrySet) {
            tempAL = currentEntry.getValue();
            if (tempAL.getSize() > countermost) {
            countermost = tempAL.getSize();
            tempStr = currentEntry.getKey();
            } else {
            }
    }
        return tempStr;
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
        boolean related = false;
        for (int i=0;i<pattern.length();i++) {
            if (pattern.charAt(i) == '1'){ 
            } else if (pattern.charAt(i) != comparison.charAt(i)) {
                return false;
            } else {
                related=true;
            }
        }
        return related;
    }
            
    
    public static Boolean guessChecker(int guessesleft) {
        return guessesleft != 0;
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
    
    public static char continueGame() {
        Scanner scnr = new Scanner(System.in);
        char result;
        System.out.println("Would you like to play again y/n");
        result = scnr.next().charAt(0);
        return result;
    }
        
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
    
    public static boolean containsdig(String currentguess) {
        boolean result = false;
        for (int i=0; i<currentguess.length();i++)
            if (currentguess.charAt(i) == '1') {
                return true;
            } else {
                
            }
        return result;
    }
    public static void gameLogic(int guesses,boolean hasWon, boolean hasGuessleft, String currentFamily, WordsDictionary tempdic, WordsDictionary devious,char guess, int wordLength,Scanner scnr,Random rand) {
        char cont ='y';
        System.out.println("How many letters do you want?");
            wordLength = scnr.nextInt();
            currentFamily = wordCreator(wordLength);
            if (wordLength >= 26) {
                guesses = rand.nextInt(25,1);
                hasGuessleft = true;
            } else {
                guesses = wordLength -1;
                hasGuessleft = true;
            }
            Family<String> wordsList = new Family();
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
            devious.add(currentFamily, wordsList);
       do {
        if (!guessChecker(guesses)) {
            System.out.println("you lose");
            break;
        }else if (!containsdig(currentFamily)) {
            System.out.println("yay you win");
            break;
        }else {
               guess = getGuess();
               tempdic = revampFamily(devious,currentFamily,guess);
               currentFamily = isBiggestFamily(tempdic,currentFamily);
               System.out.println(currentFamily);
               devious.clear();
               devious = tempdic.TailorDic(tempdic, currentFamily);
               tempdic.clear();
               guesses--;
               
            }
        } while (!hasWon || hasGuessleft);
       cont = continueGame();
        if (cont=='y') {
            devious.clear();
            tempdic.clear();
            hasWon = false;
            wordLength = 0; 
            guesses = 0;
            currentFamily ="";
            gameLogic(guesses, hasWon, hasGuessleft, currentFamily, tempdic, devious, guess, wordLength, scnr, rand);
        } else {
            System.exit(0);
        }
    }
    
    
    
    
    
    
    
}
