//day 3 daily chalenge nov2025
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;  // final answer
        int i = 0;          // pointer for traversal
        int n = colors.length();

        while (i < n) {
            char currentColor = colors.charAt(i);

            // store all consecutive balloons of the same color
            int sumTime = 0;
            int maxTime = 0;

            // jab tak same color milta rahe, add karte jao
            while (i < n && colors.charAt(i) == currentColor) {
                sumTime += neededTime[i];
                maxTime = Math.max(maxTime, neededTime[i]);
                i++;
            }

            // remove all except the one with max time
            totalTime += (sumTime - maxTime);
        }
        return totalTime;
    }
}