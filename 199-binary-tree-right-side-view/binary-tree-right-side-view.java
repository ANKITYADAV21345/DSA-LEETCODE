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



 //apna college notes(using hashmap thoda logic tweek)
class Solution {

    static class info{
        TreeNode node;
        int level;

        info(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();

        if(root==null){
            return ans;
        }

        Queue<info> q=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        q.add(new info(root,0));
        int maxLevel=0;

        while(!q.isEmpty()){
            info cur=q.remove();
            TreeNode node=cur.node;
            int level=cur.level;

            map.put(level,node.val);
            maxLevel=Math.max(maxLevel,level);

            if(node.left!=null){
                q.add(new info(node.left,level+1));
            }
            if(node.right!=null){
                q.add(new info(node.right,level+1));
            }
        }
        for(int i=0;i<=maxLevel;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}