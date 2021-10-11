package com.oasis.problems.baidu;

import com.oasis.datastructure.TreeNode;

// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

public class Jianzhi68 {
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        // 核心表达式就是这个 要么左右子树分别包含，要么就是p或q之一就是root
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

}
