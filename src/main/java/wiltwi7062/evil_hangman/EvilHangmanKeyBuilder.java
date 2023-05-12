/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

/**
 *
 * @author wiltw
 */
public class EvilHangmanKeyBuilder {
    public static String Pattern(String testWord, char letterGuess, String origPattern) {
        String newPattern = origPattern;
        char[] addArr = new char[origPattern.length()];
        for (int i=0;i<origPattern.length();i++) {
            addArr[i] = origPattern.charAt(i);
        }
        for (int j=0;j<testWord.length();j++) {
            if (testWord.charAt(j)==letterGuess) {
                newPattern = addChar(newPattern, letterGuess, j);
            }
        }
        return newPattern;
    }
    
    public static String addChar(String str, char ch, int position) {
        char[]addArr = new char[str.length()];
        for (int i=0;i<str.length();i++) {
            addArr[i] = str.charAt(i);
        }
        addArr[position] = ch;
        return new String(addArr);
    }
    
}
