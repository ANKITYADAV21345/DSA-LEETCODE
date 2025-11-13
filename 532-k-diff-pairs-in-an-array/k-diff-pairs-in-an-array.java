//apna college notes
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int index: nums){
            map.put(index,map.getOrDefault(index,0)+1);
        }
        int result=0;
        for(int key:map.keySet()){
            if((k>0 && map.containsKey(key+k))|| (k==0 && map.get(key)>1)){
                result++;
            } 
        }
        return result;
    }
}