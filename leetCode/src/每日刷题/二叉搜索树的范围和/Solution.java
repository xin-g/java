package 每日刷题.二叉搜索树的范围和;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 深度优先搜索
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST_1(TreeNode root, int low, int high) {
        if(root == null) return 0;

        if(root.val > high) return rangeSumBST_1(root.left,low,high);

        if(root.val < low) return rangeSumBST_1(root.right,low,high);

        return root.val + rangeSumBST_1(root.left, low,high) + rangeSumBST_1(root.right,low,high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null) continue;;

            if(node.val > high){
                q.offer(node.left);
            }else if(node.val < low){
                q.offer(node.right);
            }else {
                sum += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode( int val){
        this.val = val;
    }
    TreeNode( int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

}
