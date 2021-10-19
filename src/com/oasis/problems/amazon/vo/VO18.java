package com.oasis.problems.amazon.vo;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VO18 {

    private List<Integer> list = new ArrayList<>();

    public boolean isZero(TreeNode root) {
        preOrder(root);
        Map<Integer, Integer> feqMap = new HashMap<>();
        for (int i: list) {
            feqMap.put(i, feqMap.getOrDefault(i, 0) + 1);
        }
        for (int k: feqMap.keySet()) {
            if (feqMap.containsKey(-k)) {
                if (k != 0) {
                    return true;
                }
                if (feqMap.get(0) >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        VO18 vo18 = new VO18();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node4.right = node7;

        TreeNode root = node1;

        System.out.println(vo18.isZero(root));

    }

}
