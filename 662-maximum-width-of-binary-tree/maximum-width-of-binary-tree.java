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

//codebix
// class Solution {
//     public int widthOfBinaryTree(TreeNode root) {
//         if (root == null)
//             return 0;

//         Deque<TreeNode> dq = new LinkedList<>();
//         dq.add(root);

//         int max = 1;
//         while (!dq.isEmpty()) {
//             while (!dq.isEmpty() && dq.getFirst() == null)
//                 dq.removeFirst();
//             while (!dq.isEmpty() && dq.getLast() == null)
//                 dq.removeLast();
//             max = Math.max(max, dq.size());
//             int size = dq.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode temp = dq.poll();
//                 if (temp == null) {
//                     dq.add(null);
//                     dq.add(null);
//                 } else {
//                     dq.add(temp.left);
//                     dq.add(temp.right);
//                 }

//             }
//         }
//         return max;
//     }
// }



//working code through chat gpt
class Solution {
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;  // To avoid integer overflow
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int idx = current.index - minIndex; // Normalize to prevent overflow

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (current.node.left != null)
                    queue.offer(new Pair(current.node.left, 2 * idx));
                if (current.node.right != null)
                    queue.offer(new Pair(current.node.right, 2 * idx + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
