package com.oasis.problems.baidu;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        ans.add(root);
        while (!ans.isEmpty()) {
            int n = ans.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode node = ans.get(0);
                if (Objects.nonNull(node)) {
                    level.add(node.val);
                    ans.add(node.left);
                    ans.add(node.right);
                }
                ans.remove(0);
            }
            res.add(level);
        }
        res.remove(res.size() - 1);
        return res;
    }
}
