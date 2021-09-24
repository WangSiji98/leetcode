package com.oasis.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        set.add(new int[]{1, 2});
        System.out.println(set.contains(new int[]{1, 2}));
    }

}
