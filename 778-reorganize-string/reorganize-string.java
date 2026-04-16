//code storywithmik
// koi bhi character jiska frequency n+1/2 se jyada a jaye to ham posible arangement nahi kar payege 

import java.util.*;

public class Solution {

    static class Pair {
        int count;
        char ch;

        Pair(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public static String reorganizeString(String s) {
        int n = s.length();

        int[] count = new int[26];

        // frequency count
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;

            if (count[ch - 'a'] > (n + 1) / 2) {
                return "";
            }
        }

        // max-heap (based on count)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> b.count - a.count
        );

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch - 'a'] > 0) {
                pq.add(new Pair(count[ch - 'a'], ch));
            }
        }

        StringBuilder result = new StringBuilder();

        while (pq.size() >= 2) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            result.append(p1.ch);
            result.append(p2.ch);

            p1.count--;
            p2.count--;

            if (p1.count > 0) {
                pq.add(p1);
            }

            if (p2.count > 0) {
                pq.add(p2);
            }
        }

        // if one element left
        if (!pq.isEmpty()) {
            result.append(pq.poll().ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}