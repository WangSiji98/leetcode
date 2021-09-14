package com.oasis.problems.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode767 {
    // store the frequency of each character in the string
    Map<Character, Integer> map = new HashMap<>();

    // max heap
    // default is min heap, and this is max heap
    PriorityQueue<Character> pq = new PriorityQueue<>(
        new Comparator<Character>() {
            @Override
            public int compare(Character ch1, Character ch2) {
                return map.get(ch2) - map.get(ch1);
            }
        }
    );

    public String reorganizeString(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Character ch: map.keySet()) {
            pq.offer(ch);
        }
        if (n % 2 == 0 && map.get(pq.peek()) > n / 2 || n % 2 == 1 && map.get(pq.peek()) > n / 2 + 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (pq.size() > 1) {
            char ch1 = pq.peek();
            int count1 = map.get(ch1);
            pq.poll();
            char ch2 = pq.peek();
            int count2 = map.get(ch2);
            pq.poll();
            if (count1 > 1) {
                map.put(ch1, --count1);
                pq.offer(ch1);
            } else {
                map.remove(ch1);
            }
            if (count2 > 1) {
                map.put(ch2, --count2);
                pq.offer(ch2);
            } else {
                map.remove(ch2);
            }
            stringBuilder.append(ch1);
            stringBuilder.append(ch2);
        }
        if (pq.size() == 1){
            stringBuilder.append(pq.poll());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode767 leetCode767 = new LeetCode767();
        String s = "baaba";
        System.out.println(leetCode767.reorganizeString(s));
    }

}
