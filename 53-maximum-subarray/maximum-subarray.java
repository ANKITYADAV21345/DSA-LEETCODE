//apna college notes
//kadans algorithm
//jaise hi negative ho jaye sum  use 0 kar do 
class Solution {
    public int maxSubArray(int[] nums) {

        int maxsum = Integer.MIN_VALUE;
        int cursum = 0;

        for(int i = 0; i < nums.length; i++) {

            cursum =cursum + nums[i];

            maxsum = Math.max(maxsum, cursum);

            if(cursum < 0) {
                cursum = 0;
            }
        }

        return maxsum;
    }
}



//agar bol dete ki max subarray bhi print karo to  2 variable aur jud jayege ansStart and ansend jo index dege kaha se kaha tak 

// class Solution {
//     public int maxSubArray(int[] nums) {

//         int maxsum = Integer.MIN_VALUE;
//         int cursum = 0;

//         int start = 0;
//         int ansStart = 0;
//         int ansEnd = 0;

//         for (int i = 0; i < nums.length; i++) {

//             cursum = cursum + nums[i];

//             if (cursum > maxsum) {
//                 maxsum = cursum;
//                 ansStart = start;
//                 ansEnd = i;
//             }

//             if (cursum < 0) {
//                 cursum = 0;
//                 start = i + 1;
//             }
//         }

//         System.out.print("Maximum Subarray : ");
//         for (int i = ansStart; i <= ansEnd; i++) {
//             System.out.print(nums[i] + " ");
//         }

//         System.out.println();
//         System.out.println("Maximum Sum : " + maxsum);

//         return maxsum;
//     }
// }

