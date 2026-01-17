//coding with vinod
//binary search in a range
class Solution {
    public int minCapability(int[] nums, int k) {
        int left=Integer.MAX_VALUE;
        int res=0;
        int right=Integer.MIN_VALUE;

        for(int i:nums){
            left=Math.min(left,i);
            right=Math.max(right,i);
        }

        while(left<=right){
            int mid=left+(right-left)/2;
            if(selectk(nums,k,mid)){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }

    public boolean selectk(int [] nums,int k,int mid){
        int count=0;
        int i=0;
        while(i<nums.length){
            if(nums[i]<=mid){
            count++;
            i++;
        }
        i++;
        }
        return count>=k;
    }
}