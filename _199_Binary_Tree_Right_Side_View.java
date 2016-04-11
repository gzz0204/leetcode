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
    public List<Integer> rightSideView(TreeNode root) {
        // level order traverse
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        list.add(root);
        while(!list.isEmpty()){
            TreeNode tmpNode = list.getLast();
            res.addLast(tmpNode.val);
            int size = list.size();
            while(size > 0){
                tmpNode = list.removeLast();
                if(tmpNode.right != null){
                    list.addFirst(tmpNode.right);
                }
                if(tmpNode.left != null){
                    list.addFirst(tmpNode.left);
                }
                size --;
            }
        }
        return res;
    }
}
