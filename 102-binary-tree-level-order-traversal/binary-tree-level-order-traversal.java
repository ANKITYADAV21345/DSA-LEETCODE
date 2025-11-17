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






//done by my self (recursion)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelorder(root, 0, result);

        return result;
    }

    public void levelorder(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        // If this level doesn't exist yet, create it
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // Add value to current level
        result.get(level).add(node.val);

        // Recur for children
        levelorder(node.left, level + 1, result);
        levelorder(node.right, level + 1, result);
    }
}
   
   