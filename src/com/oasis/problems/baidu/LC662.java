package com.oasis.problems.baidu;

import com.oasis.datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// 层序遍历
public class LC662 {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        //使用节点的值来记录节点在二叉树上的位置
        root.val = 0;
        queue.add(root);
        int res = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int n = queue.size();
            //队列结尾减去开头的值加一即为当前层的宽度
            res = Math.max(res, queue.getLast().val - queue.getFirst().val + 1);
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    node.left.val = node.val * 2;
                    queue.add(node.left);
                }
                if(node.right != null){
                    node.right.val = node.val * 2 + 1;
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

}
