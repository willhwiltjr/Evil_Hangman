
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
    
    public static WordsDictionary revampFamily (WordsDictionary treeMap,String currentOutput, char currentGuess) { // this will update the current working WordsDictionary
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
    
    
    public static String isBiggestFamily(WordsDictionary treeMap,String currentPattern) { // this returns the key of the Family with the largest size
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
            
    
    public static Boolean guessChecker(int guessesleft) { //self explainatory
        return guessesleft != 0;
    }
    
    public static String wordCreator(int wordlength) { // simply creates a string of 1's the length of word taken from file
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
    
    public static char continueGame() {  //handles branch for playing again or system close
        Scanner scnr = new Scanner(System.in);
        char result;
        System.out.println("Would you like to play again y/n");
        result = scnr.next().charAt(0);
        return result;
    }
        
    public static char getGuess() {  //gets user input returns char
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
        char cont ='y';  //bumper to contain any mishaps with continue method CYA variable
        System.out.println("How many letters do you want? enter a number please");
            wordLength = scnr.nextInt();
            currentFamily = wordCreator(wordLength);
            if (wordLength >= 26) {
                guesses = rand.nextInt(24)+1;
                hasGuessleft = true;
            } else {
                guesses = wordLength -1;
                hasGuessleft = true;
            }
            Family<String> wordsList = new Family(); //contains initial wordlist
            try {
                wordsList = findWords(wordLength);
                if (wordsList.isEmpty()) {
                    wordsList = findWords(4);
                    wordLength = 4;
                    currentFamily = wordCreator(wordLength);
                    guesses = 6;
                    hasGuessleft = true;
                }
            } catch (InterruptedException ex) {   //ide suggested logging catch
                Logger.getLogger(Evil_Hangman.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Evil_Hangman.class.getName()).log(Level.SEVERE, null, ex);
            }
            devious.add(currentFamily, wordsList); //initial words dictionary for revamp to work on
       do {
        if (!guessChecker(guesses)) {
            System.out.println("you lose");
            break;                                 // break is necessary if you dont want an infinite loop
        }else if (!containsdig(currentFamily)) {
            System.out.println("yay you win");
            break;
        }else {
               guess = getGuess();                // player guess input
               tempdic = revampFamily(devious,currentFamily,guess);    // group up the different permutations
               currentFamily = isBiggestFamily(tempdic,currentFamily); // finds the family with the most permutations
               System.out.println(currentFamily);    //informs user of result of their guess
               devious.clear();                     // prepares devious for next run
               devious = tempdic.TailorDic(tempdic, currentFamily);  // sets devious up with the biggest key value pair for next run
               tempdic.clear();                                 // prepares tempdic for next run
               guesses--;                                  // decrements guess to keep track of succesful run
               
            }
        } while (!hasWon || hasGuessleft);
       cont = continueGame();                            // with a game finished method calls to prompt user for another game
        if (cont=='y') {                               // block resets all necessary fields then recursively calls the method for another run
            devious.clear();
            tempdic.clear();
            hasWon = false;
            wordLength = 0; 
            guesses = 0;  hasWon = false;
            wordLength = 0; 
            currentFamily ="";
            gameLogic(guesses, hasWon, hasGuessleft, currentFamily, tempdic, devious, guess, wordLength, scnr, rand);
        } else {                                         // if continueGame returns any character other than 'y' this block exits the program entirely
            System.exit(0);
        }
    }
    
    
    
    
    
    
    
}
