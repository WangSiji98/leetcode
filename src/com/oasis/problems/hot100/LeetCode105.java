package com.oasis.problems.hot100;

import com.oasis.datastructure.TreeNode;
import java.util.Arrays;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n < 1) {
            return null;
        }
        int rootVal = preorder[0];
        int rootIndex = search(inorder, rootVal);
        if (rootIndex == -1) {
            return null;
        }
        TreeNode root = new TreeNode(rootVal);
        int leftLength = rootIndex;
        int rightLenght = (n - 1) - rootIndex;
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftLength);
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftLength, 1 + leftLength + rightLenght);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftLength);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftLength + 1, leftLength + 1 + rightLenght);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;

    }

    private int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
