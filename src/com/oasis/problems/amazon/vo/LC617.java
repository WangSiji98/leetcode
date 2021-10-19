package com.oasis.problems.amazon.vo;

import com.oasis.datastructure.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class LC617 {

    // 递归
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 :root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        TreeNode left = mergeTrees1(root1.left, root2.left);
        TreeNode right = mergeTrees1(root1.right, root2.right);
        root.left = left;
        root.right = right;
        return root;
    }

    // 迭代
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 :root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode cur1 = queue.poll();
            TreeNode cur2 = queue.poll();
            cur1.val += cur2.val;
            if (cur1.left != null && cur2.left != null) {
                queue.offer(cur1.left);
                queue.offer(cur2.left);
            } else if (cur1.left == null) {
                cur1.left = cur2.left;
            }
            if (cur1.right != null && cur2.right != null) {
                queue.offer(cur1.right);
                queue.offer(cur2.right);
            } else if (cur1.right == null) {
                cur1.right = cur2.right;
            }
        }
        return root1;
    }

}
