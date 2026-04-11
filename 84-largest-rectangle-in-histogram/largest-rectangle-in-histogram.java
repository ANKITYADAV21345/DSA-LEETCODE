//apna college notes

class Solution {
    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        int n = heights.length;

        int[] nsr = new int[n];
        int[] nsl = new int[n];

        // next smaller right
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = stack.peek();
            }

            stack.push(i);
        }

        // next smaller left
        stack = new Stack<>(); 
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }

        // current area
        for (int i = 0; i < n; i++) {
            int height = heights[i]; 
            int width = nsr[i] - nsl[i] - 1;
            int curArea = height * width;

            maxArea = Math.max(curArea, maxArea);
        }

        return maxArea;
    }
}