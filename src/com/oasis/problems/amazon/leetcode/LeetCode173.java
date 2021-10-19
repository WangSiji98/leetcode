package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LeetCode173 {
    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    class BSTIterator {
        private List<Integer> list;
        int cur = 0;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }

        public int next() {
            return list.get(cur++);
        }

        public boolean hasNext() {
            if (cur >= list.size()) {
                return false;
            } else {
                return true;
            }
        }
    }



}
