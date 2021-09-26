package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LeetCode337 {
     public int rob(TreeNode root) {
         List<Integer> res = traverse(root);
         return Math.max(res.get(0), res.get(1));
     }

    public List<Integer> traverse(TreeNode root) {
        if (Objects.isNull(root)) {
            return Arrays.asList(0, 0);
        }
        List<Integer> left = traverse(root.left);
        List<Integer> right = traverse(root.right);
        return new ArrayList<Integer>(){{
            add(root.val + left.get(1) + right.get(1));
            add(Math.max(left.get(0), left.get(1)) + Math.max(right.get(0), right.get(1)));
        }};
    }

}
