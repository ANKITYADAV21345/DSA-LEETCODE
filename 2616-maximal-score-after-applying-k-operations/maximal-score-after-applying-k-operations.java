//codestorywithmik

import java.util.*;

public class Solution {

    public static long maxKelements(int[] nums, int k) {

        long sum = 0;

        // priority_queue<int> pq(begin(nums), end(nums));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        while (k-- > 0) {

            int maxEl = pq.peek();
            pq.poll();

            sum += maxEl;

            maxEl = (int) Math.ceil(maxEl / 3.0);

            pq.add(maxEl);
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {10, 10, 10};
        int k = 5;

        long ans = maxKelements(nums, k);

        System.out.println("Result: " + ans);
    }
}