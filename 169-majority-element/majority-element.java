//apna colege article 
class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int count=1;
        int majority=nums[0];//assuming the first element as candidate


        //phase 1:find potential majority candidate
        for(int i=0;i<n;i++){
            if(nums[i]==majority){
                count++;
            }
            else{
                count--;
                if(count==0){
                    majority=nums[i];
                    count=1;
                }
            }
        }

        //phase 2 verify the candidate
        count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==majority){
                count++;
            }
        }

        //return the element if it occur more then  n/2
        if(count>=n/2){
            return majority;
        }else{
            return -1;
        }



    }
}