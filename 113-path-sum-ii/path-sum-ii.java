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
//changes made from chatgpt from path sum 1 to path sum 2
public class Solution {

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null)
      return result;

    Stack<TreeNode> path = new Stack<>();
    Stack<Integer> sumPath = new Stack<>();
    Stack<List<Integer>> paths = new Stack<>();

    path.push(root);
    sumPath.push(root.val);
    paths.push(new ArrayList<>(Arrays.asList(root.val)));

    while (!path.isEmpty()) {
      TreeNode temp = path.pop();
      int tempVal = sumPath.pop();
      List<Integer> currentPath = paths.pop();

      if (temp.left == null && temp.right == null && tempVal == sum) {
        result.add(new ArrayList<>(currentPath));
      }

      if (temp.right != null) {
        path.push(temp.right);
        sumPath.push(temp.right.val + tempVal);
        List<Integer> newPath = new ArrayList<>(currentPath);
        newPath.add(temp.right.val);
        paths.push(newPath);
      }

      if (temp.left != null) {
        path.push(temp.left);
        sumPath.push(temp.left.val + tempVal);
        List<Integer> newPath = new ArrayList<>(currentPath);
        newPath.add(temp.left.val);
        paths.push(newPath);
      }
    }

    return result;
  }
}
