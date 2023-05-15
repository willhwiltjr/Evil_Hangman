/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

/**
 *
 * @author wiltw
 */
public class methodsTester extends Evil_Hangman {
    
    public static void main(String[] args) {
        String are = "are",air = "air",bob = "bob",arefamily = "1r1", airfamily = "a11";
        System.out.println("testing ismatching");
        System.out.println("are & are : " + ismatching(are, are));
        System.out.println("should be false: " + ismatching(are,air));
        System.out.println("should be false: " + ismatching(are,bob));
        
        System.out.println("testing isFamilyRelated");
        System.out.println("shoudl be true: " + isFamilyRelated(arefamily, are));
        System.out.println("should be true: " + isFamilyRelated(airfamily, are));
        System.out.println("should be false: " + isFamilyRelated(arefamily, air));
        
        
    }
    
}
