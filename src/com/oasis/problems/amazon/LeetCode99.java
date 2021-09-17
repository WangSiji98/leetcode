package com.oasis.problems.amazon;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LeetCode99 {
    private List<Integer> midOrderList = new ArrayList<>();
    private Map<Integer, TreeNode> map = new HashMap<>();

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root);
        int first = 0, second = 0;
        int n = midOrderList.size();
        int i = 0;
        while (i < n - 1) {
            if (midOrderList.get(i) > midOrderList.get(i + 1)) {
                first = midOrderList.get(i);
                break;
            }
            ++i;
        }
        i = n - 1;
        while (i > 0) {
            if (midOrderList.get(i) < midOrderList.get(i - 1)) {
                second = midOrderList.get(i);
                break;
            }
            --i;
        }
        map.get(first).val = second;
        map.get(second).val = first;
    }

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        midOrderList.add(root.val);
        map.put(root.val, root);
        midOrder(root.right);
    }

    public static void main(String[] args) {
        LeetCode99 leetCode99 = new LeetCode99();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;

        TreeNode root = node1;
        leetCode99.recoverTree(root);
    }

}
