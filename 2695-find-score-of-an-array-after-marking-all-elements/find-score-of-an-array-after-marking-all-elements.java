//codestorywithmik
//aproach 2

import java.util.*;

public class Solution {

    public static long findScore(int[] nums) {

        int n = nums.length;

        // vector<bool> visited(n, false);
        boolean[] visited = new boolean[n];

        // priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>>
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        );

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }

        long score = 0;

        while (!pq.isEmpty()) {

            int[] temp = pq.poll();

            int element = temp[0];
            int idx = temp[1];

            if (!visited[idx]) {

                visited[idx] = true;
                score += element;
            

                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                }

                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 3, 4, 5, 2};

        long ans = findScore(nums);

        System.out.println("Score: " + ans);
    }
}