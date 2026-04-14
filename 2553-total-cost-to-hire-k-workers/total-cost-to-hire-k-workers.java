//codestorywithmik

class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        long ans = 0;

        int hired = 0;
        int i = 0;
        int j = n - 1;

        while (hired < k) {

            while (pq1.size() < candidates && i <= j) {
                pq1.add(costs[i++]);
            }

            while (pq2.size() < candidates && j >= i) {
                pq2.add(costs[j--]);
            }

            int a;
            if (pq1.size() > 0) {
                a = pq1.peek();
            } else {
                a = Integer.MAX_VALUE;
            }

            int b;
            if (pq2.size() > 0) {
                b = pq2.peek();
            } else {
                b = Integer.MAX_VALUE;
            }

            if (a <= b) {
                ans =ans + a;
                pq1.poll();
            } else {
                ans += b;
                pq2.poll();
            }

            hired++;
        }

        return ans;
    }
}