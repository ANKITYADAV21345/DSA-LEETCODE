//apna college
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;

        //eadge case 1
        if(n==1){
            return nums[0];
        }

        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            //eadge case 2
            if(mid==0 && nums[0]!=nums[1]){
                return nums[mid];
            }

            //eadge case 3
            if(mid==n-1 && nums[n-1]!=nums[n-2]){
                return nums[mid];
            }

            //mid pe hi mill gaya
            if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

            //agar mid index even hai

            // Yeh logic pair pattern pe based hai: sorted array me 
            //pairs normally (even, odd) index par hote hain. Agar 
            //mid even hai aur uska pair left me ban raha hai 
            //(nums[mid-1] == nums[mid]), toh pattern toot chuka hai → answer left side me hai;
            //warna right me. Aur agar mid odd hai, toh pair ideally left me hi hona chahiye — agar hai toh sab sahi hai → 
            //right jao, warna pattern break → left jao.


            if(mid%2==0){//even
                if(nums[mid-1]==nums[mid]){//left
                   end=mid-1; 
                }else{//right
                    start=mid+1;
                }
            }else{//odd
                if(nums[mid-1]==nums[mid]){//right
                   start=mid+1;
                }else{//left
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}