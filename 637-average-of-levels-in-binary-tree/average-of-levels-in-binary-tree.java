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





//done by own (recursion) isme arraylist ka set function ache se use hua hai
class Solution {

    List<Double> levelSum = new ArrayList<>();
    List<Integer> levelCount = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        fillLevelData(root, 0);

        List<Double> result = new ArrayList<>();
        for (int i = 0; i < levelSum.size(); i++) {
            result.add(levelSum.get(i) / levelCount.get(i));
        }

        return result;
    }

    // Full name instead of dfs
    private void fillLevelData(TreeNode node, int level) {
        if (node == null) return;

        // If this is the first time we reach this level
        if (level == levelSum.size()) {
            levelSum.add((double) node.val);
            levelCount.add(1);
        } 
        else {
            levelSum.set(level, levelSum.get(level) + node.val);
            levelCount.set(level, levelCount.get(level) + 1);
        }

        fillLevelData(node.left, level + 1);
        fillLevelData(node.right, level + 1);
    }
}
