//apna college

// Yeh code rotated sorted array me binary search use karta hai. Har step pe hum mid nikalte hain aur check karte hain ki left half sorted hai ya right half. Agar nums[start] <= nums[mid] hai, matlab left part sorted hai — phir dekhte hain target us range me aata hai ya nahi; agar haan, toh left me search (end = mid-1), warna right me (start = mid+1). Agar left sorted nahi hai, toh right part sorted hoga — phir same logic wahan apply karte hain.



class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]==target){
                return mid;
            }
            //left sorted
            if(nums[start]<=nums[mid]){
                if(nums[start]<=target && target<=nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{//right sorted
                if(nums[mid]<=target && target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}