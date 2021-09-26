package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.Objects;

public class leetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (Objects.isNull(root1) && Objects.isNull(root2)) {
            return null;
        }
        if (Objects.isNull(root1) || Objects.isNull(root2)) {
            return Objects.isNull(root1) ? root2 : root1;
        }
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = left;
        newRoot.right = right;
        return newRoot;
    }

}
