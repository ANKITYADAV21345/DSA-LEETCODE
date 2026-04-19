//codestorywithmik
//aproach 2
public class Solution {

    public static int minOperations(int[] nums, int k) {

        // priority_queue<long, vector<long>, greater<long>>
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add((long) num);
        }

        int count = 0;

        while (!pq.isEmpty() && pq.peek() < k) {

            long smallest = pq.poll(); // minimum

            if (pq.isEmpty()) break; // safety (avoid crash)

            long secondSmallest = pq.poll();

            pq.add(smallest * 2 + secondSmallest);

            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int ans = minOperations(nums, k);

        System.out.println("Operations: " + ans);
    }
}