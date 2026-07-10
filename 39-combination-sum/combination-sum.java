//apna college article knive aproach
class Solution
{
   private void helper(int[] nums, int target, int index, int n, List<Integer> current, Set<List<Integer>> set)   {
       if (index == n) {
           if (target == 0) {
               set.add(new ArrayList<>(current));
           }
           return;
       }


       // Not pick the current element
       helper(nums, target, index + 1, n, current, set);


       // Pick the current element if it doesn't exceed the target
       if (nums[index] <= target) {
           current.add(nums[index]);
           helper(nums, target - nums[index], index, n, current, set);
           current.remove(current.size() - 1); // backtrack
       }
   }




   public List<List<Integer>> combinationSum(int[] candidates, int target)
   {
       Set<List<Integer>> set = new HashSet<>();
       List<Integer> tempList = new ArrayList<>();
       helper(candidates, target, 0, candidates.length, tempList, set);
      
       return new ArrayList<>(set);
    }
}