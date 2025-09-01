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
    public void flatten(TreeNode root) {
        flattenBST(root);
    }

    public TreeNode flattenBST(TreeNode root) {
        if(root == null) return null;
        TreeNode leftTail = flattenBST(root.left);
        TreeNode rightTail = flattenBST(root.right);

        if(leftTail != null) {
            // Attach right subtree after leftTail
            leftTail.right = root.right;
            // Move left subtree to the right
            root.right = root.left;
            root.left = null;
        }

        // Return the last node (rightmost) after flattening
        if(rightTail != null) return rightTail;
        if(leftTail != null) return leftTail;
        return root;
    }
}