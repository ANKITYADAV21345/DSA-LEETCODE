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

    class Pair {
        TreeNode first;
        long second;

        Pair(TreeNode first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int maxWidth = 0;

        while (queue.size() > 0) {

            int currLevelSize = queue.size();

            long stIdx = queue.peek().second;

            long endIdx = 0;
            for (Pair p : queue) {
                endIdx = p.second;
            }

            maxWidth = Math.max(maxWidth, (int)(endIdx - stIdx + 1));

            for (int i = 0; i < currLevelSize; i++) {

                Pair curr = queue.peek();
                queue.remove();

                if (curr.first.left != null) {
                    queue.add(new Pair(curr.first.left, curr.second * 2 + 1));
                }

                if (curr.first.right != null) {
                    queue.add(new Pair(curr.first.right, curr.second * 2 + 2));
                }
            }
        }

        return maxWidth;
    }
}