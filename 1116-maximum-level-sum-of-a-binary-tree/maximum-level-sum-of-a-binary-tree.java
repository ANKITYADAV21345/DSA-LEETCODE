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



//apna college
class Solution {

    public int maxLevelSum(TreeNode root) {

        ArrayList<Integer> levelSum = new ArrayList<>();
        levelOrder(root, 0, levelSum);

        int maxSum = Integer.MIN_VALUE; 
        int ansLevel = 0;

        for (int i = 0; i < levelSum.size(); i++) {
            if (levelSum.get(i) > maxSum) {
                maxSum = levelSum.get(i);
                ansLevel = i;
            }
        }

        return ansLevel + 1;
    }

    public void levelOrder(TreeNode root, int level, ArrayList<Integer> levelSum) {

        if (root == null) {
            return;
        }

        // new level
        if (level == levelSum.size()) {
            levelSum.add(root.val);
        } else {//existing level me add kar rahe hai
            levelSum.set(level, levelSum.get(level) + root.val);
        }

        levelOrder(root.left, level + 1, levelSum);
        levelOrder(root.right, level + 1, levelSum);
    }
}