package com.oasis.problems.amazon.leetcode;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        boolean reverseFlag = false;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode cur = queue.remove();
                ans.add(cur.val);
                if (Objects.nonNull(cur.left)) {
                    queue.add(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    queue.add(cur.right);
                }
            }
            if (reverseFlag) {
                Collections.reverse(ans);
            }
            res.add(ans);
            reverseFlag = !reverseFlag;
        }
        return res;
    }



}
