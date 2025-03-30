
import java.util.Stack;

class Solution {
    private int res;
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
