//codestorywithmik
public class Solution {

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;

        int[][] vec = new int[n][2];

        for (int i = 0; i < n; i++) {
            vec[i][0] = capital[i];
            vec[i][1] = profits[i];
        }

        // sort based on capital
        Arrays.sort(vec, (a, b) -> a[0] - b[0]);

        int i = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (k-- > 0) {

            while (i < n && vec[i][0] <= w) {
                pq.add(vec[i][1]);
                i++;
            }

            if (pq.isEmpty()) {
                break;
            }

            w =w + pq.peek();
            pq.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}