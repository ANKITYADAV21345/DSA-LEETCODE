//microsoft me pucha tha mujhse 5th sem me
//codestorywithmik 
import java.util.*;

public class Solution {

    public static String longestDiverseString(int a, int b, int c) {

        // priority_queue<pair<int,char>> pq; // max-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> y[0] - x[0]   // max heap based on count
        );

        if (a > 0) {           
            pq.add(new int[]{a, 'a'});//freq,character
        }
        if (b > 0) {
            pq.add(new int[]{b, 'b'});
        }
        if (c > 0) {
            pq.add(new int[]{c, 'c'});
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            int[] top = pq.poll();
            int currCount = top[0];
            char currChar = (char) top[1];

            int len = result.length();

            // check last 2 characters
            if (len >= 2 &&
                result.charAt(len - 1) == currChar &&
                result.charAt(len - 2) == currChar) {

                // can't use currChar
                if (pq.isEmpty()) {
                    break;
                }
                //next character add karege 
                int[] next = pq.poll();
                int nextCount = next[0];
                char nextChar = (char) next[1];

                result.append(nextChar);
                nextCount--;

                if (nextCount > 0) {
                    pq.add(new int[]{nextCount, nextChar});
                }

                // push back current
                pq.add(new int[]{currCount, currChar});
            }
            else {
                result.append(currChar);
                currCount--;

                if (currCount > 0) {
                    pq.add(new int[]{currCount, currChar});
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int a = 1, b = 1, c = 7;

        String ans = longestDiverseString(a, b, c);

        System.out.println("Result: " + ans);
    }
}