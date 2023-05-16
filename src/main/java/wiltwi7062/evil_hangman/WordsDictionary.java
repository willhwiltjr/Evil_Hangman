/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author wiltw
 * @param <String>
 * @param <Family>
 * @param <<error>>
 */
public class WordsDictionary extends TreeMap {
    private final String keys;
    private int mySize;
    private final Family values;
    
    public WordsDictionary() {
        keys = "";
        mySize = 0;
        values = new Family();
    }
    
    public WordsDictionary add(String key, Family value) {
        if (keys.contains(key)) {
            int location = keys.indexOf(key);
            Family temp = new Family();
            temp.add(values.getEntry(location));
            mySize++;
            this.replace(key, temp);
        } else {
            put(key,value);
            mySize++;
            return this;
        }
        return this;
    }
    
    public String Remove(String key) {      
        if (keys.contains(key)) {
            int location = keys.indexOf(key);
            values.remove(location);
            mySize--;
            return key;
        } else {
            return null;
        }        
    }
    public  WordsDictionary AppendDic(WordsDictionary subject, String familyaddition, String additionkey) {
        WordsDictionary temp = new WordsDictionary();
        temp = subject;
        if(subject.containsKey(additionkey)) {
            Set<Map.Entry<String, Family>> entrySet = (subject.entrySet());
            for(Map.Entry<String, Family> currentEntry : entrySet) {
                if (currentEntry.getKey().equals(additionkey)) {
                    Family tempfam = new Family();
                    Iterator<String> familyiterator = currentEntry.getValue().iterator();
                    while (familyiterator.hasNext()) {
                        tempfam.add(familyiterator.next());
                    }
                    tempfam.add(familyaddition);
                    temp.add(additionkey, tempfam);
                } else {
                    temp.add(currentEntry.getKey(), currentEntry.getValue());
                    mySize++;
                }
            
            }
        } else {
            Family throwaway = new Family();
            throwaway.add(familyaddition);
            temp.add(additionkey, throwaway);
        }
        return temp;
    }
    
    
    
    
    
    
    public boolean contains(String key) {
        return keys.contains(key);               
    }  
    
    
    
    public Iterator getValueIterator() {    
        return values.iterator();          
    } 
    
    @Override
    public boolean isEmpty() {  
        return mySize==0;        
    } 
    
    
    
    
}
