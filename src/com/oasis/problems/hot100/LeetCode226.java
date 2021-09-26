package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.Objects;

public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
