//apna college notes maam ne 2 arr leke karaya tha tha thoda sa tweek kiya hai ki ans list<list >> me dena hai acha examole hai ki ham kaise apne ap apne padhe hue ko tweek kare oa me 

import java.util.*;
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            minDiff=Math.min(minDiff,Math.abs(arr[i]-arr[i+1]));
        }
        
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1])==minDiff){
                result.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return result;
    }
}