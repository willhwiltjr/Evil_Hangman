/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author wiltw
 * @param <String>
 */
public class Family<String>  implements Iterable<String>{
    private String[] myArray;   // array of list entries
    private int mySize;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;  

    // public methods:  
    public Family()
    {
        this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    public Family(int initialCapacity)
    {
        mySize=0;
       @SuppressWarnings("unchecked")       
       String[] tempArray = (String[]) new Object[initialCapacity];
       myArray = tempArray;
       //mySize = tempArray.length + 1;
    } // end constructor

    public boolean isEmpty()
    {
        return mySize==0;
    } // end isEmpty
//    public int getMySize() {
//        return mySize;
//    }
    
    public void add(String newEntry) {
        ensureCapacity();
           if (mySize == 0) {
               myArray[0] = newEntry;
               mySize++;
           } else {
               myArray[mySize] = newEntry;
               mySize++;
           }
    } // end     add

    public boolean add(int newPosition, String newEntry) {
        
       if (newPosition == 0 || newPosition > mySize + 1) {
        return false; 
       } else if (myArray[newPosition - 1] == null){
        myArray[newPosition - 1] = newEntry;
        mySize++;
        return true;
       } else {
           try { 
                ensureCapacity();
                    for ( int i = mySize;i>=newPosition;i--) {
                        myArray[i] = myArray[i-1];
                    }
                myArray[newPosition-1] = newEntry;
                mySize++;
                return true;
               } catch (ArrayIndexOutOfBoundsException e) {
                   return false;
                   }
       }
    
    

    }// end add

    public String remove(int givenPosition) {
        int index = givenPosition-1;
        String removedItem;
        if (index < 0 || index >= mySize) {
            return null;
        } else {
            removedItem = myArray[index];
            for (int i = index;i<mySize-1;i++) {
                myArray[i] = myArray[i+1];
            }
            mySize--;
            return removedItem;
        }
    } // end remove

    public void clear()
    {
        for (int k=0; k<mySize; k++)
            myArray[k] = null;
        mySize = 0;
    } // end clear

    public boolean replace(int givenPosition, String newEntry)
    {
        int index = givenPosition-1;
        if (index < 0 || index >= mySize) {
            return false;
        } else {
            myArray[index] = newEntry;
            return true;
    }
    }// end replace

    public String getEntry(int givenPosition)
    {  
        int index = givenPosition-1;
        if (index < 0 || index > mySize) {
            return null;
        } else {
        return myArray[index];
        } // end getEntry
    }

    public boolean contains(String anEntry)
    {
        boolean found = false;
        for (int index = 0; !found && (index < mySize); index++)
        {
            if (anEntry.equals(myArray[index]))
                found = true;
        } // end for

        return found;
    } // end contains

    public int getSize()
    {
        return mySize;
    } // end getLength

    private void ensureCapacity()
    {
       if (mySize == myArray.length)
           myArray = Arrays.copyOf(myArray, 2 * myArray.length);
    }
    public void moveToEnd(int givenPosition) {
        String replacedItem;
        if (!isEmpty()) {
            replacedItem = remove(givenPosition);
            mySize++;
            myArray[mySize-1] = replacedItem;
        }
        
    }
    public int getPosition(String anEntry) {
        int index;
        while (!isEmpty()) {
            if (contains(anEntry)) {
            for (int i = 0; i<mySize; i++) {
                if (getEntry(i+ 1).equals(anEntry)) {
                   index = i + 1;
                   return index; 
                } else {
                    
                }
            }
            
        } else {
            index = -1;
            return index; 
        }
    }
       index = -1;
       return index; 
    }
    
   public Object[] toArray()
   {
      Object[] result = new Object[mySize];
        System.arraycopy(myArray, 0, result, 0, mySize); // end for
      return result;
   } // end toArray
    

    @Override
    public Iterator<String> iterator() {
       return new MySimpleIterator<>();
    }
    private class MySimpleIterator<T> implements Iterator<T> {
     int cursor;
     public MySimpleIterator() {
        cursor = -1;
     }
     @Override
     public boolean hasNext() {
        return cursor < mySize -1;
     }
     @Override
     public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        cursor++;
        @SuppressWarnings("unchecked")
        T temp = (T) myArray[cursor];
        return temp;
     }
     @Override
     public void remove() {
      throw new UnsupportedOperationException();  
     }
    }
}
   

        

    

