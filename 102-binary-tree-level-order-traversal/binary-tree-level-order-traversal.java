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


//apna college notes
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outerList = new ArrayList<>();
        if (root == null) return outerList;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> innerList = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();

            if (currNode == null) {
                outerList.add(innerList);
                if (q.isEmpty()) break;
                innerList = new ArrayList<>();
                q.add(null);
            } else {
                innerList.add(currNode.val);

                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
        }

        return outerList;
    }
}
