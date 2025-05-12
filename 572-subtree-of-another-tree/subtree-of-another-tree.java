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




 //RECURSIVE SOLUTION
// class Solution {
//     public static boolean isIdentical(TreeNode node, TreeNode subRoot) {
//         if (node == null && subRoot == null) {
//             return true;
//         } else if (node == null || subRoot == null || node.val != subRoot.val) {
//             return false;
//         }

//         return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
//     }

//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         if (root == null) {
//             return false;
//         }

//         if (root.val == subRoot.val) {
//             if (isIdentical(root, subRoot)) {
//                 return true;
//             }
//         }

//         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
//     }
// }


//ITERATIVE SOLUTION 
public class Solution{
    String preOrderTraversal(TreeNode node){
        if(node==null){
            return "null";
        }

        StringBuilder sb=new StringBuilder("^");
        sb.append(node.val);
        sb.append(preOrderTraversal(node.left));
        sb.append(preOrderTraversal(node.right));

        return sb.toString();
    }

     boolean isSubtree(TreeNode root, TreeNode subRoot) {

    String fullTree = preOrderTraversal(root);
    String subTree = preOrderTraversal(subRoot);

    return (fullTree.contains(subTree));
    }
}
