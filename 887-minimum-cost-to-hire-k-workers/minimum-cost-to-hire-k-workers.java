//codestorywithmik

//aproach 3(optimised)

import java.util.*;

public class Solution {

    public static double mincostToHireWorkers(int[] quality, int[] min_wage, int k) {

        int n = quality.length;

        double result = Double.MAX_VALUE;

        // vector<pair<double,int>> worker_ratio
        double[][] worker_ratio = new double[n][2];

        for (int worker = 0; worker < n; worker++) {
            worker_ratio[worker][0] = (double) min_wage[worker] / quality[worker]; // ratio
            worker_ratio[worker][1] = quality[worker]; // quality
        }

        // sort(begin, end)
        Arrays.sort(worker_ratio, (a, b) -> Double.compare(a[0], b[0]));

        // priority_queue<int> -> max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sum_quality = 0;

        // first k workers
        for (int i = 0; i < k; i++) {
            pq.add((int) worker_ratio[i][1]);
            sum_quality += (int) worker_ratio[i][1];
        }

        double managerRatio = worker_ratio[k - 1][0];
        result = managerRatio * sum_quality;

        for (int manager = k; manager < n; manager++) { // O(n)

            managerRatio = worker_ratio[manager][0];

            pq.add((int) worker_ratio[manager][1]);
            sum_quality += (int) worker_ratio[manager][1];

            if (pq.size() > k) {
                sum_quality -= pq.peek();
                pq.poll();
            }

            result = Math.min(result, managerRatio * sum_quality);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] quality = {10, 20, 5};
        int[] min_wage = {70, 50, 30};
        int k = 2;

        double ans = mincostToHireWorkers(quality, min_wage, k);

        System.out.println("Minimum Cost: " + ans);
    }
}