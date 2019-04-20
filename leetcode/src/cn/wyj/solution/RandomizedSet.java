package cn.wyj.solution;

import java.util.HashSet;
import java.util.Random;

public class RandomizedSet {
    private HashSet s;
    private Random rd;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        s = new HashSet();
        rd = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return s.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return s.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

         for (int i=0; i<rd.nextInt(s.size()); i++)
             s.iterator().next();
         return (int)s.iterator().next();
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
