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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return splitTree(postorder, inOrderIndexMap,
                postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode splitTree(int[] postorder, Map<Integer, Integer> inOrderIndexMap,
            int rootIndex, int left, int right) {

        // Base case: invalid subtree
        if (left > right || rootIndex < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[rootIndex]);

        int mid = inOrderIndexMap.get(postorder[rootIndex]);

        int rightSubtreeSize = right - mid;

        // Recursively build right and left subtrees
        root.right = splitTree(postorder, inOrderIndexMap,
                rootIndex - 1, mid + 1, right);

        root.left = splitTree(postorder, inOrderIndexMap,
                rootIndex - rightSubtreeSize - 1, left, mid - 1);

        return root;
    }
}
