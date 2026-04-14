//codestorywithmik
import java.util.*;

class Solution {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // vector<array<int,3>> ka equivalent
        int[][] sortedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            int start_time = tasks[i][0];
            int processing_time = tasks[i][1];

            sortedTasks[i][0] = start_time;
            sortedTasks[i][1] = processing_time;
            sortedTasks[i][2] = i;
        }

        // sort based on start_time
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> result = new ArrayList<>();

        long curr_time = 0;
        int idx = 0;

        // min-heap (processing_time, index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        );

        while (idx < n || !pq.isEmpty()) {

            if (pq.isEmpty() && curr_time < sortedTasks[idx][0]) {
                curr_time = sortedTasks[idx][0];
            }

            while (idx < n && sortedTasks[idx][0] <= curr_time) {
                pq.add(new int[]{sortedTasks[idx][1], sortedTasks[idx][2]});
                idx++;
            }

            int[] curr_task = pq.poll();

            curr_time += curr_task[0]; // processing time
            result.add(curr_task[1]);
        }

        // List -> array
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}