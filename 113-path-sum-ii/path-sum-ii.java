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




//done by my own(recursion +backtracking)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> outerList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();

        sumList(root, targetSum, innerList, outerList);

        return outerList;
    }

    private void sumList(TreeNode root, int targetSum, 
                        List<Integer> path, 
                        List<List<Integer>> result) {

        if (root == null) return;

        // add current node
        path.add(root.val);

        // leaf node check
        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(path));  // copy list
        }

        // explore left and right
        sumList(root.left, targetSum - root.val, path, result);
        sumList(root.right, targetSum - root.val, path, result);

        // backtrack
        path.remove(path.size() - 1);
    }
}
