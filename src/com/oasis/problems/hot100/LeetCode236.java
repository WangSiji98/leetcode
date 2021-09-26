package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.Objects;

public class LeetCode236 {
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return this.ans;
    }

    private boolean search(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root)) {
            return false;
        }
        boolean left = search(root.left, p, q);
        boolean right = search(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            this.ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }
}
