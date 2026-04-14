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

            int minfrompq1;
            if (pq1.size() > 0) {
                minfrompq1 = pq1.peek();
            } else {
                minfrompq1 = Integer.MAX_VALUE;
            }

            int minfrompq2;
            if (pq2.size() > 0) {
                minfrompq2 = pq2.peek();
            } else {
                minfrompq2 = Integer.MAX_VALUE;
            }

            if (minfrompq1 <= minfrompq2) {
                ans =ans + minfrompq1;
                pq1.poll();
            } else {
                ans = ans + minfrompq2;
                pq2.poll();
            }

            hired++;
        }

        return ans;
    }
}