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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return splitTree(preorder, inOrderIndexMap,
                0, 0, inorder.length - 1);
    }

    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderIndexMap,
            int rootIndex, int left, int right) {

        // Base case: invalid subtree
        if (left > right || rootIndex >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[rootIndex]);

        int mid = inOrderIndexMap.get(preorder[rootIndex]);

        int leftSubtreeSize = mid - left;

        // Recursively build left and right subtrees
        root.left = splitTree(preorder, inOrderIndexMap,
                rootIndex + 1, left, mid - 1);

        root.right = splitTree(preorder, inOrderIndexMap,
                rootIndex + leftSubtreeSize + 1, mid + 1, right);

        return root;
    }
}
