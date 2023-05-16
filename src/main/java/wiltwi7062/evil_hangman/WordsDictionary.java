/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

import java.util.ArrayList;
import java.util.Iterator;
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
    private final Family values;
    
    public WordsDictionary() {
        keys = "";
        values = new Family();
    }
    
    public WordsDictionary add(String key, Family value) {
        if (keys.contains(key)) {
            int location = keys.indexOf(key);
            Family temp = new Family();
            temp.add(values.getEntry(location));
            this.replace(key, temp);
        } else {
            put(key,value);
            return this;
        }
        return this;
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
