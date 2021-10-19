package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.TreeNode;
import java.util.Objects;

public class LeetCode572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (Objects.isNull(root)) {
            return false;
        }
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }
        if (Objects.isNull(p) || Objects.isNull(q) || p.val != q.val) {
            return false;
        }
        return check(p.left, p.left) && check(p.right, q.right);
    }
}
