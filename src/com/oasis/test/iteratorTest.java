package com.oasis.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class iteratorTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(4);
        deque.addLast(3);

//        for (Iterator iter = deque.iterator(); iter.hasNext();) {
//            System.out.println(iter.next());
//        }
        for (Integer i : deque) {
            System.out.println(i);
        }
    }

}
