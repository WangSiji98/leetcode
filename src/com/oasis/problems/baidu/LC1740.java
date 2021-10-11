package com.oasis.problems.baidu;

import com.oasis.datastructure.TreeNode;

// 二叉树任意两个节点的距离
public class LC1740 {
    public int findDistance(TreeNode root, int p, int q) {
        if(p == q){
            return 0;
        }
        // 公共祖先
        TreeNode parent = findCommonParent(root,p,q);
        // 节点到公共祖先的距离
        return getNodeDepth(parent,p) + getNodeDepth(parent,q);
    }

    // 首先寻找公共祖先
    private TreeNode findCommonParent(TreeNode root, int p, int q){
        if(root == null){
            return null;
        }
        if(root.val == p || root.val == q){
            return root;
        }
        TreeNode left = findCommonParent(root.left,p,q);
        TreeNode right = findCommonParent(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }

    // 到root节点的距离
    private int getNodeDepth(TreeNode root,int p){
        if(root == null){
            // -1表示当前路径不是p的路径
            return -1;
        }
        if(root.val == p){
            return 0;
        }
        int left = getNodeDepth(root.left,p);
        int right = getNodeDepth(root.right,p);
        int ans = Math.max(left,right);
        // 最大值是-1的话，表示不是p的路径，>= 0则表示找到的p的路径，再加上自己本身的距离
        return ans >= 0 ? ans + 1 : -1;
    }

}
