//ye khud se kiya
import java.util.*;

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=pq.poll();
        }
    }
}