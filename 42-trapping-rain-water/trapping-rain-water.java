//stack solution
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int trapped = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Jab higher bar mile
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int bottom = st.pop(); // bowl ka bottom
                
                if (st.isEmpty()) break;

                int left = st.peek(); // left boundary
                int width = i - left - 1;
                int heightWater = Math.min(height[left], height[i]) - height[bottom];
                
                trapped += width * heightWater;
            }

            st.push(i);
        }
        
        return trapped;
    }
}
