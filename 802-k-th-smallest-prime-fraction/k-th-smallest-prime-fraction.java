//codestorywithmik aproach 2

public class Solution {

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;

        // min-heap {fraction, i, j}
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(a[0], b[0])
        );

        for (int i = 0; i < n; i++) {
            // denominator = arr[n-1] (largest)
            pq.add(new double[]{(double) arr[i] / arr[n - 1], (double) i, (double) (n - 1)});
        }

        int smallest = 1; // first smallest

        while (smallest < k) {

            double[] vec = pq.peek();
            pq.poll();

            int i = (int) vec[1]; // index
            int j = (int) vec[2] - 1; // index

            pq.add(new double[]{(double) arr[i] / arr[j], (double) i, (double) j});

            smallest++;
        }

        double[] vec = pq.peek();

        int i = (int) vec[1];
        int j = (int) vec[2];

        return new int[]{arr[i], arr[j]};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int k = 3;

        int[] res = kthSmallestPrimeFraction(arr, k);
        System.out.println(res[0] + " " + res[1]);
    }
}