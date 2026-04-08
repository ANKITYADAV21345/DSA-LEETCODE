//apnacollege tweek of next greater element 1



// Jab kisi element ka first greater mil jata hai
// → usko queue me daal do (ab wo second greater ka wait karega)
// Jab kisi ko second greater milta hai
// → answer fill kar do
import java.util.*;

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> s1 = new Stack<>(); // first greater
        Stack<Integer> s2 = new Stack<>(); // second greater wait

        for (int i = 0; i < n; i++) {

            // Step 1: second greater
            while (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                ans[s2.pop()] = nums[i];
            }

            // Step 2: move from s1 → s2
            Stack<Integer> temp = new Stack<>();
            while (!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
                temp.push(s1.pop());
            }

            while (!temp.isEmpty()) {
                s2.push(temp.pop());
            }

            // Step 3
            s1.push(i);
        }

        return ans;
    }
}