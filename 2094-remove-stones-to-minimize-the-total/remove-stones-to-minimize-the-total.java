//codestorywithmik

class Solution {

    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            pq.add(piles[i]);
            sum =sum + piles[i];
        }

        for (int i = 1; i <= k; i++) {
            int curr = pq.poll();

            int remove = curr / 2;
            sum = sum - remove;

            int remaining = curr - remove;

            pq.add(remaining);
        }

        return sum;
    }

    // optional main for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] piles = {5, 4, 9};
        int k = 2;
        System.out.println(sol.minStoneSum(piles, k));
    }
}