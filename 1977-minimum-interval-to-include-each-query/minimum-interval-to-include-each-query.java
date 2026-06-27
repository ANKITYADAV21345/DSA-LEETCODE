//coding ninjas webinars and contest editorial && WEB FUSION WITH BHARDWAJ

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int n = intervals.length;
        int m = queries.length;

        // Store query value with its original index
        int[][] qWithIdx = new int[m][2];
        for (int i = 0; i < m; i++) {
            qWithIdx[i] = new int[]{queries[i], i};
        }

        Arrays.sort(qWithIdx, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        // {intervalSize, rightEnd}
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int idx = 0;

        for (int[] qi : qWithIdx) {
            int qVal = qi[0];
            int qOrig = qi[1];

            while (idx < n && intervals[idx][0] <= qVal) {
                int left = intervals[idx][0];
                int right = intervals[idx][1];
                int size = right - left + 1;

                pq.offer(new int[]{size, right});
                idx++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < qVal) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                ans[qOrig] = pq.peek()[0];
            } else {
                ans[qOrig] = -1;
            }
        }

        return ans;
    }
}