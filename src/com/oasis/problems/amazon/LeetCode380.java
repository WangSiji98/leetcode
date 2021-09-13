package com.oasis.problems.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LeetCode380 {
    class RandomizedSet {
        // hashmap key -> index in list
        private Map<Integer, Integer> map;
        // arraylist store value;
        public List<Integer> list;

        private Random rand;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            rand = new Random();
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            Collections.swap(list, index, list.size() - 1);
            map.put(list.get(index), index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int randIndex = rand.nextInt(list.size());
            return list.get(randIndex);
        }

    }

}
