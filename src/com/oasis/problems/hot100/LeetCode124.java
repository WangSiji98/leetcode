package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.List;
import java.util.Objects;
import sun.font.GlyphLayout.LayoutEngineFactory;

public class LeetCode124 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return res;
    }

    private int max(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int leftMax = Math.max(0, max(root.left));
        int rightMax = Math.max(0, max(root.right));
        int cur = root.val + leftMax + rightMax;
        res = Math.max(res, cur);

        return root.val + Math.max(leftMax, rightMax);
    }
}
