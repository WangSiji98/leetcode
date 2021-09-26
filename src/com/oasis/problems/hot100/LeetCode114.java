package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.Objects;

public class LeetCode114 {
    public void flatten(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        flatten(root.left);
        TreeNode left = root.left;
        flatten(root.right);
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode tmp = root;
        while (Objects.nonNull(tmp)) {
            tmp = tmp.right;
        }
        tmp.right = right;
    }
}
