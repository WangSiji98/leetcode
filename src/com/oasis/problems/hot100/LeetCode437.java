package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 前缀和 经典题目
public class LeetCode437 {
    private Map<Integer, Integer> map = null;
    private int targetnum;
    private int num;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetnum = targetSum;
        map = new HashMap<>();
        map.put(0, 1);
        search(root, 0);
        return num;
    }

    private void search(TreeNode root, int curSum) {
        if (Objects.isNull(root)) {
            return;
        }
        // 更新前缀和
        curSum += root.val;
        // 搜索当前的路径情况
        num += map.getOrDefault(curSum - targetnum, 0);
        // 更新这条路径上的前缀和
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        search(root.left, curSum);
        search(root.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }

    public static void main(String[] args) {
        LeetCode437 leetCode437 = new LeetCode437();
        TreeNode root = new TreeNode(1);
        int tragetNum = 0;
        System.out.println(leetCode437.pathSum(root, tragetNum));
    }

}
