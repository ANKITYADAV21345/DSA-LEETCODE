//codestorywithmik
//bruteforce
import java.util.*;

public class Solution {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(interval);
        }

        int i = 0;

        // O(n^2) because insert/remove in ArrayList can shift elements
        while (i < list.size()) { // O(n)

            // Current interval completely before newInterval
            if (list.get(i)[1] < newInterval[0]) {
                i++;
            }

            // Current interval completely after newInterval
            else if (list.get(i)[0] > newInterval[1]) {
                list.add(i, newInterval); // insert at position i
                return list.toArray(new int[list.size()][]);
            }

            // Overlapping intervals
            else {
                // Merge and remove current interval
                newInterval[0] = Math.min(newInterval[0], list.get(i)[0]);
                newInterval[1] = Math.max(newInterval[1], list.get(i)[1]);

                list.remove(i); // erase merged interval
            }
        }

        // If newInterval goes at the end
        list.add(newInterval);

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = {2, 5};

        int[][] result = insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}