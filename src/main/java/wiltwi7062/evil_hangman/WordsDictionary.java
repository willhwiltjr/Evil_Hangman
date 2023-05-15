/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author wiltw
 * @param <<error>>
 */
public class WordsDictionary extends TreeMap {
    private final String keys;
    private final Family values;
    
    public WordsDictionary() {
        keys = "";
        values = new Family();
    }
    
    public ArrayList add(String key, String value) {
        if (keys.contains(key)) {
            int location = keys.indexOf(key);
            ArrayList<String> temp = (ArrayList)values.getEntry(location);
            temp.add(value);
            return temp;
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(value);
            put(key,temp);
            return null;
        }
    }
    
    public String Remove(String key) {      
        if (keys.contains(key)) {
            int location = keys.indexOf(key);
            values.remove(location);
            return key;
        } else {
            return null;
        }        
    }
    
    
    
    public boolean contains(String key) {
        return keys.contains(key);               
    }  
    
    
    
    public Iterator getValueIterator() {    
        return values.iterator();          
    } 
    
    @Override
    public boolean isEmpty() {  
        return keys.isEmpty();        
    } 
    
    
    
    
}
