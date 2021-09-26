package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.Objects;

public class LeetCode543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = Integer.MIN_VALUE;
        search(root);
        return max;
    }

    public int search(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = search(root.left);
        int right = search(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }

}

