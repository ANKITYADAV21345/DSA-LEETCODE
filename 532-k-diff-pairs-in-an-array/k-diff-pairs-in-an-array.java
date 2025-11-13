//done by my self
import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        //eadge case
        if (k < 0) return 0; // diffrence cannot be negative
        HashMap <Integer,Integer> map=new HashMap<>();
        int count =0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);// nums[i]->freq (created map)
        }

        for(int val: map.keySet()){
            
            if (k == 0) {
                // count only numbers that appear more than once
                if (map.get(val) > 1) count++;
            } else {
                if (map.containsKey(val + k)) count++;
            }
            
        }
        return count;
    }
}