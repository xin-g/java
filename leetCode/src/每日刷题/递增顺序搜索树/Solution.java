package 每日刷题.递增顺序搜索树;

import java.util.ArrayList;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        linkTreeNode(root,list);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;

        for(Integer val : list){
            currNode.right = new TreeNode(val);
            currNode = currNode.right;
        }

        return dummyNode.right;
    }

    public void linkTreeNode(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        TreeNode res = new TreeNode();

        linkTreeNode(root.left,list);
        list.add(root.val);
        linkTreeNode(root.right,list);
    }
}
