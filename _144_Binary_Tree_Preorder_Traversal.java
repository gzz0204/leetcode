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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> aux = new LinkedList<>();
        if(root == null){
            return res;
        }
        aux.addFirst(root);
        TreeNode firstNode = null;
        while(!aux.isEmpty()){
            firstNode = aux.removeFirst();
            res.add(firstNode.val);
            if(firstNode.right != null){
                aux.addFirst(firstNode.right);
            }
            if(firstNode.left != null){
                aux.addFirst(firstNode.left);
            }
        }
        return res;
    }
}
