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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

         Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);

        return splitTree(preorder, inorderIndexMap,0, 0, inorder.length - 1);
  }

  private TreeNode splitTree(int[] preorder, Map<Integer, Integer> inorderIndexMap,
                            int rootIndex, int left, int right) {

    TreeNode root = new TreeNode(preorder[rootIndex]);

    // Create left and right subtree
    int mid = inorderIndexMap.get(preorder[rootIndex]);
    if (mid > left)
      root.left = splitTree(preorder, inorderIndexMap,
          rootIndex + 1, left, mid - 1);
    if (mid < right)
      root.right = splitTree(preorder, inorderIndexMap,
        rootIndex + mid - left + 1, mid + 1, right);
    return root;
    }
}