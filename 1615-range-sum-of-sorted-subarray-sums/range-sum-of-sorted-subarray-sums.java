//CODESTORYWITHMIK
//APROACH 2

public class Solution {

    static int M = (int)1e9 + 7;

    public static int rangeSum(int[] nums, int n, int left, int right) {

        // priority_queue<P, vector<P>, greater<P>> pq;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]   // min heap based on sum
        );

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }

        int result = 0;

        for (int counter = 1; counter <= right; counter++) {

            int[] p = pq.poll();

            int sum = p[0];
            int idx = p[1];

            if (counter >= left) {
                result = (result + sum) % M;
            }

            int new_idx = idx + 1;

            if (new_idx < n) {
                int[] new_pair = new int[2];
                new_pair[0] = sum + nums[new_idx];
                new_pair[1] = new_idx;

                pq.add(new_pair);
            }
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