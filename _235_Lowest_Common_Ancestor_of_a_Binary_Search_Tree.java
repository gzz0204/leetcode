/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return null;
        }
        TreeNode common = root;
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while(common != null && (common.val < min || common.val > max)){
            if(common.val < min){
                common = common.right;
            }else{
                common = common.left;
            }
        }
        return common;
    }
}
