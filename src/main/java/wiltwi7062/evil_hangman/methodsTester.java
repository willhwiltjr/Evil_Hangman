/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static wiltwi7062.evil_hangman.EvilHangmanKeyBuilder.Pattern;
import static wiltwi7062.evil_hangman.Evil_Hangman.wordCreator;
import static wiltwi7062.evil_hangman.FileHandler.findWords;

/**
 *
 * @author wiltw
 */
public class methodsTester extends Evil_Hangman {
    
    public static void main(String[] args) {
//        String are = "are",air = "air",bob = "bob",arefamily = "1r1", airfamily = "a11", far = "far";
//        System.out.println("testing ismatching");
//        System.out.println("are & are : " + ismatching(are, are));
//        System.out.println("should be false: " + ismatching(are,air));
//        System.out.println("should be false: " + ismatching(are,bob));
//        
//        System.out.println("testing isFamilyRelated");
//        System.out.println("shoudl be true: " + isFamilyRelated(arefamily, are));
//        System.out.println("should be true: " + isFamilyRelated(airfamily, are));
//        System.out.println("should be false: " + isFamilyRelated(arefamily, air));
//        
//        System.out.println("Testing wordCreator");
//        String test;
//        int guess = 3;
//        test = wordCreator(guess);
//        System.out.println("should be 111: " + test );
        
//        System.out.println("testing getGuess and pattern");
//        char charguess = getGuess();
//        test = Pattern(air,charguess,test);
//        System.out.println("should be 11r: " + test);
//        charguess = getGuess();
//        test = Pattern(far,charguess,test);
//        System.out.println("should be f1r: " + test);
//        charguess = getGuess();
//        test = Pattern(far,charguess,test);
//        System.out.println("should be far: " + test);
        
//        System.out.println("testing Family");
//        Family devious = new Family();
//        devious.add(far);
//        devious.add(air);
//        devious.add(bob);
//        devious.add(are);
//        Iterator<String> familyiterator = devious.iterator();
//        while (familyiterator.hasNext()) {
//           System.out.println((String)familyiterator.next());
//        }
//        System.out.println("should be far air bob are");
//        Family update = updateList(devious, "bat");
//        devious = updateList(update, "rat");
//        while (familyiterator.hasNext()) {
//           System.out.println(familyiterator.next());
//        }
//        System.out.println("should be bat rat");
//        updatePlayer(test);
        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);   
        boolean hasGuessleft;
        String currentFamily ="", tempStr = "";
        int wordLength, guesses, count = 0;
        char guess;
        WordsDictionary devious = new WordsDictionary();
        WordsDictionary tempdic = new WordsDictionary();
        Family current = new Family();
        Family tempF = new Family();
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
        System.out.println(wordLength);
        while (guesses > 0) {
        if (!guessChecker(guesses)) {
            System.out.println("you lose");
        }else if (!containsdig(currentFamily)) {
            System.out.println("yay you win");
        }else {
               guess = getGuess();
               tempdic = revampFamily(devious,currentFamily,guess);
               System.out.println(tempdic.size());
               currentFamily = isBiggestFamily(tempdic,currentFamily);
               System.out.println(currentFamily);
               devious.clear();
               devious = tempdic.TailorDic(tempdic, currentFamily);
               tempdic.clear();
               guesses--;
               
            }
        }
        }

    }
    

