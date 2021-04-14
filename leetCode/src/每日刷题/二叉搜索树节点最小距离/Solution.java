package 每日刷题.二叉搜索树节点最小距离;

public class Solution {
    int pre;
    int ans;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        if (pre != -1){
            ans = Math.min(ans,root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}

