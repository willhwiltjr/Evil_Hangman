/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

import java.util.Iterator;
import static wiltwi7062.evil_hangman.EvilHangmanKeyBuilder.Pattern;

/**
 *
 * @author wiltw
 */
public class methodsTester extends Evil_Hangman {
    
    public static void main(String[] args) {
        String are = "are",air = "air",bob = "bob",arefamily = "1r1", airfamily = "a11", far = "far";
        System.out.println("testing ismatching");
        System.out.println("are & are : " + ismatching(are, are));
        System.out.println("should be false: " + ismatching(are,air));
        System.out.println("should be false: " + ismatching(are,bob));
        
        System.out.println("testing isFamilyRelated");
        System.out.println("shoudl be true: " + isFamilyRelated(arefamily, are));
        System.out.println("should be true: " + isFamilyRelated(airfamily, are));
        System.out.println("should be false: " + isFamilyRelated(arefamily, air));
        
        System.out.println("Testing wordCreator");
        String test;
        int guess = 3;
        test = wordCreator(guess);
        System.out.println("should be 111: " + test );
        
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
        
        System.out.println("testing Family");
        Family devious = new Family();
        devious.add(far);
        devious.add(air);
        devious.add(bob);
        devious.add(are);
        Iterator<Family> familyiterator = devious.iterator();
        while (familyiterator.hasNext()) {
           System.out.println(familyiterator.next());
        }
        System.out.println("should be far air bob are");
        Family update = updateList(devious, "bat");
        devious = updateList(update, "rat");
        while (familyiterator.hasNext()) {
           System.out.println(familyiterator.next());
        }
        System.out.println("should be bat rat");
        updatePlayer(test);
        
        
        
        
    }
    
}
