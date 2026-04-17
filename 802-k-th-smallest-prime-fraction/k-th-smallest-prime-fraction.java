//codestorywithmik aproach1

public class Solution {

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0]) // max-heap
        ); // {fraction, arr[i], arr[j]}

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                double div = (double) arr[i] / arr[j];

                pq.add(new double[]{div, (double) arr[i], (double) arr[j]});

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        double[] vec = pq.peek(); // {fraction, arr[i], arr[j]}

        int[] result = new int[2];
        result[0] = (int) vec[1];
        result[1] = (int) vec[2];

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int k = 3;

        int[] res = kthSmallestPrimeFraction(arr, k);
        System.out.println(res[0] + " " + res[1]);
    }
}