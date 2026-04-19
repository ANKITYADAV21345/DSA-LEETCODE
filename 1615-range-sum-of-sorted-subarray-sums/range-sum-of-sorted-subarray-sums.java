//CODESTORYWITHMIK
//APROACH 1

public class Solution {

    static int M = (int)1e9 + 7;

    public static int rangeSum(int[] nums, int n, int left, int right) {

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];
                temp.add(sum);
            }
        }

        Collections.sort(temp);

        int result = 0;

        for (int i = left - 1; i <= right - 1; i++) {
            result = (result + temp.get(i)) % M;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int n = nums.length;
        int left = 1, right = 5;

        int ans = rangeSum(nums, n, left, right);

        System.out.println("Result: " + ans);
    }
}