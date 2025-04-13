class Solution {
    public static int singleNumber(int nums[]){
        int value=0;    //to store the valueinitialise it with 0
        for(int i=0;i<nums.length;i++)//to scan the elements from left to right
        {
            value=value^nums[i];
        }
        return value;
    }


    public static void main(String args[])  {
        int nums[]={4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }


}