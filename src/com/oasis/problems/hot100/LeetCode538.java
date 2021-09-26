package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.Objects;

public class LeetCode538 {
    private int ans = 0;

    public TreeNode convertBST(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        convertBST(root.right);
        ans += root.val;
        root.val = ans;
        convertBST(root.left);
        return root;
    }

}
