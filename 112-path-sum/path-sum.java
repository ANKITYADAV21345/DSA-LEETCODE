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
//nikhil lohia 
public class Solution {

  boolean hasPathSum(TreeNode root, int sum) {

    if (root == null)
      return false;

    // Create 2 stacks for the path and the sums
    Stack<TreeNode> path = new Stack<>();
    Stack<Integer> sumPath = new Stack<>();

    path.push(root);
    sumPath.push(root.val);

    while (!path.isEmpty()) {
      TreeNode temp = path.pop();
      int tempVal = sumPath.pop();

      // If a child node and we find the sum total, return true
      if (temp.left == null && temp.right == null && tempVal == sum)
        return true;

      if (temp.right != null) {
        path.push(temp.right);
        sumPath.push(temp.right.val + tempVal);
      }

      if (temp.left != null) {
        path.push(temp.left);
        sumPath.push(temp.left.val + tempVal);
      }

    }

    return false;
  }
}