//study placement
class Solution {
    public long countSubarrays(int[] nums, long k) {
        TreeSet<Integer> set = new TreeSet<>(
            (a,b) -> {
                if(nums[a] != nums[b]){
                    return nums[a] - nums[b];
                }
                return a - b;
            }
        );
        int n = nums.length; int j=0, i=0; long ans = 0;
        while(j < n){
            set.add(j);
            long min = (long)nums[set.first()];
            long max = (long)nums[set.last()];
            long cnt = set.size();
            while(i <= j && (max - min) * cnt > k){
                set.remove(i);
                i++;
                max = (long)nums[set.last()];
                min = (long)nums[set.first()];
                cnt = set.size();
            }
            ans += set.size();
            j++;
        }
        return ans;
    }
}