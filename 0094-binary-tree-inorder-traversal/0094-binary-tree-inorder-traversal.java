/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //method for inorder traversal
    public static void inorder(TreeNode root , List<Integer> result){
        if(root == null){
            return ;
        }

        //print left-subtree
        inorder(root.left,result);

        // root print
        result.add(root.val);


        //print right-subtree
        inorder(root.right,result);

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        //create a arraylist 
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }
}