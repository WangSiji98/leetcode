package com.oasis.problems.amazon;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeetCode144 {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }

    private void preorder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        LeetCode144 leetCode144 = new LeetCode144();
        System.out.println(leetCode144.preorderTraversal(node1));
    }

}
