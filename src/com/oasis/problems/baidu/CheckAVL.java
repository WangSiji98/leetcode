package com.oasis.problems.baidu;

import com.oasis.datastructure.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CheckAVL {
    private Map<TreeNode, Integer> map = new HashMap<>();

    public boolean isAVL(TreeNode root) {
        if (root==null) {
            return true;
        }
        if (root.left != null && root.left.val > root.val) {
            return false;
        }
        if (root.right != null && root.right.val < root.val) {
            return false;
        }
        int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
        return isAVL(root.left) && isAVL(root.right) && diff <= 1;
    }
    public int getHeight(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        } else {
            int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
            map.put(root, height);
            return height;
        }
    }

    public static void main(String[] args) {
        CheckAVL checkAVL = new CheckAVL();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(1);

        node4.left = node3;
        node4.right = node6;
        node3.left = node2;
//        node2.left = node1;

        TreeNode root = node4;

        System.out.println(checkAVL.isAVL(root));
    }
    
}
