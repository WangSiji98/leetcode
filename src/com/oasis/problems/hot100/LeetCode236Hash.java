package com.oasis.problems.hot100;

import com.oasis.datastructure.ListNode;
import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class LeetCode236Hash {
    private Map<TreeNode, TreeNode> prevMap = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.prevMap = new HashMap<>();
        dfs(root, null);
        Set<TreeNode> visited = new HashSet<>();
        while (Objects.nonNull(p)) {
            visited.add(p);
            p = this.prevMap.get(p);
        }
        while (Objects.nonNull(q)) {
            if (visited.contains(q)) {
                return q;
            }
            q = this.prevMap.get(q);
        }
        return null;
    }

    private void dfs(TreeNode root, TreeNode prev) {
        if (Objects.isNull(root)) {
            return;
        }
        this.prevMap.put(root, prev);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}
