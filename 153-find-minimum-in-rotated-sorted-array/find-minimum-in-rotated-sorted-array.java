class Solution {
    public int findMin(int[] nums) {
        
        int left=0;
        int right=nums.length-1;

        while(left<right){

            int mid=left+(right-left)/2;

            //cheak if the middle element is greater then the right element
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
}