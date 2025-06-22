class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //create hashmap
        Map <Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){

            //get the complement using the target value 
            int complement=target - nums[i];

            //search the hashmap for complement ,if found ,we got our pair
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }

            //put the element in hashmap for subsequent searches 
            map.put(nums[i],i);
        }
        return new int []{0,0};
    }
}