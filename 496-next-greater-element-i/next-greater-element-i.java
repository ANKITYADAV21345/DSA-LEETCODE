//apna college
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        //nums 2 me next greater element nikaluga maam ki tarah
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() &&s.peek()<=nums2[i] ){
                s.pop();
            }

            if(s.isEmpty()){
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],s.peek());
            }
            s.push(nums2[i]);
        }
        //build ans for nums1
        int [] ans=new int [nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}