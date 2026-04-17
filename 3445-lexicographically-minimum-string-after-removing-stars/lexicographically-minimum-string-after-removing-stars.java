//codestorywithmik

public class Solution {

    static class Pair {
        char first;
        int second;

        Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class comp implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            if (p1.first == p2.first) {
                return p2.second - p1.second; // smaller index first → reverse for max-heap behavior
            }
            return p1.first - p2.first; // smaller char first
        }
    }

    public static String clearStars(String s) {

        int n = s.length();

        PriorityQueue<Pair> pq = new PriorityQueue<>(new comp());

        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {

            if (arr[i] != '*') {
                pq.add(new Pair(arr[i], i));
            } else {
                int idx = pq.peek().second;
                pq.poll();

                arr[idx] = '*';
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (arr[i] != '*') {
                result.append(arr[i]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abc*d*e";
        System.out.println(clearStars(s));
    }
}