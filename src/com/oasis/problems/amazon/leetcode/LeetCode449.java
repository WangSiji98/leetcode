package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;

public class LeetCode449 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    // 一棵二叉树可以通过 前序/后序 + 中序 遍历唯一确定
    // 对于二叉搜索树，其中序遍历必定是递增的，可以直接通过排序得到，所以我们只需要记录前序/后序遍历即可

    public class Codec {
        Deque<Integer> deque = null;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            deque = new ArrayDeque<>();
            preOrder(root);
            if (deque.isEmpty()) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer i : deque) {
                stringBuilder.append(i);
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("".equals(data)) {
                return null;
            }
            deque = new ArrayDeque<>();
            for (String s: data.split(" ")) {
                deque.addLast(Integer.parseInt(s));
            }
            return buildTree(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        private TreeNode buildTree(int max, int min) {
           if (deque.isEmpty()) {
               return null;
           }
           int cur = deque.getFirst();
           if (cur > max || cur < min) {
               return null;
           }
           deque.removeFirst();
           TreeNode root = new TreeNode(cur);
           root.left = buildTree(cur, min);
           root.right = buildTree(max, cur);
           return root;
        }

        private void preOrder(TreeNode root) {
            if (Objects.isNull(root)) {
                return;
            }
            deque.addLast(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }

    }



    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // String tree = ser.serialize(root);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;

}
