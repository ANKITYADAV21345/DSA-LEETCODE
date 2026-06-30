//pep coding
class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

    for(int g = 0; g < dp.length; g++){
        for(int i = 0, j = g; j < dp.length; i++, j++){
            int max = Integer.MIN_VALUE;

            for(int k = i; k <= j; k++){

                int left;
                if(k == i){
                    left = 0;
                }
                else{
                    left = dp[i][k - 1];
                }

                int right;
                if(k == j){
                    right = 0;
                }
                else{
                    right = dp[k + 1][j];
                }

                int leftVal;
                if(i == 0){
                    leftVal = 1;
                }
                else{
                    leftVal = nums[i - 1];
                }

                int rightVal;
                if(j == nums.length - 1){
                    rightVal = 1;
                }
                else{
                    rightVal = nums[j + 1];
                }

                int val = leftVal * nums[k] * rightVal;

                int total = left + right + val;

                if(total > max){
                    max = total;
                }
            }

            dp[i][j] = max;
        }
    }

    return dp[0][dp.length - 1];
    }
}