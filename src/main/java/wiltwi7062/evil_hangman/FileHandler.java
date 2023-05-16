
package wiltwi7062.evil_hangman;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wiltw
 */
public class FileHandler extends ArrayList<String> {
    
    public static Family<String> findWords (int Length) throws InterruptedException, FileNotFoundException {
        Family<String> temp = new Family();
        int wordLength = Length;    //wordlength will be the input used to pull words of length and seperate into families
        String fileName = "D:\\records keeping\\school stuff\\programming\\csis10b\\Evil_Hangman\\src\\main\\java\\Scrabble_Dictionary.txt";
        String currentLine;
        Scanner inputFile = null;  //scanner for grabbing nextline from txt file
        File Dictionary = null;
        boolean succeeded = false;
        while (!succeeded) {
            try {
                Dictionary = new File(fileName);
                inputFile = new Scanner(Dictionary);
                succeeded = true;
            } catch (FileNotFoundException e) {
                System.out.print("file not found: " + fileName);
                succeeded = false;
            }
        }
        while (inputFile.hasNextLine()) {
            currentLine = inputFile.nextLine();
            if (isLength(wordLength, currentLine)) {
                temp.add(currentLine);
            }
    
        }
        return temp;
    }
    
    public static boolean isLength ( int checklength,String check) {
        try {
            String holder = check;
            int length =0;
            for (int i = 1; i<holder.length()+1; i++)
                length += 1;
           if (length == checklength) {
               return true;
           } else {
               return false;
           }
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
    
    
    
    
}
