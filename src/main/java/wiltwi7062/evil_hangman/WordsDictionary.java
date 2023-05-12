/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wiltwi7062.evil_hangman;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author wiltw
 */
public class WordsDictionary<K, V> extends TreeMap {
    private Vector<K> keys;
    private Vector<V> values;
    
    public WordsDictionary() {
        keys = new Vector<K>();
        values = new Vector<V>();
    }
    
    public V add(K key, V value) {
        if (keys.contains(key)) {
            int location = keys.indexOf(key);
            V temp = values.get(location);
            values.set(location, value);
            return temp;
        } else {
            keys.add(key);
            values.add(value);
            return null;
        }
    }
    
    public V Remove(K key) {      
        if (keys.contains(key)) {
            int location = keys.indexOf(key);
            V temp = values.get(location);
            values.remove(location);
            keys.remove(location);
            return temp;
        } else {
            return null;
        }        
    }
    
    public V getValue(K key) {      
        if (keys.contains(key)) {
            int location = keys.indexOf(key);
            V temp = values.get(location);
            return temp;
        } else {
            return null;
        }               
    } 
    
    public boolean contains(K key) {
        return keys.contains(key);               
    }  
    
    public Iterator<K> getKeyIterator() {
        return keys.iterator();        
    }
    
    public Iterator<V> getValueIterator() {    
        return values.iterator();          
    } 
    
    @Override
    public boolean isEmpty() {  
        return keys.isEmpty();        
    } 
    
    public int getSize() {  
        return keys.size();
    }
    
    @Override
    public void clear() { 
        keys.clear();
        values.clear();
    }
    
}
