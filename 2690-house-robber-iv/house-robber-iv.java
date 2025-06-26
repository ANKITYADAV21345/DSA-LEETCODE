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
            int mid=left+((right-left)/2);
            if(selectk(nums,k,mid)){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res; 
    }
    public boolean selectk(int[] nums,int k,int mid){
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


// int n=nums.length;
        // ArrayList<Integer> ans=new ArrayList<>();
        // for(int i=0;i<n-2;i++){
        //     int j=i+2;
        //     while(j<n){
        //         if(j<n-1){
        //             ans.add(Math.max(nums[i],nums[j]));
        //         }else{
        //             ans.add(nums[i]);
        //             }
        //         }   
        //     }
        // int minnum=Integer.MAX_VALUE;
        // for(int i:ans){
        //     minnum=Math.min(i,minnum);
        // }
        // return minnum;