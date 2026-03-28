//apna college
class Solution{
    public static void getAllSubsets(int[] nums, List<Integer> ans, int i, List<List<Integer>> allSubsets) {
            if (i == nums.length) {
                allSubsets.add(new ArrayList<>(ans));
                return;
            }

            // include
            ans.add(nums[i]);
            getAllSubsets(nums, ans, i + 1, allSubsets);

            // backtrack
            ans.remove(ans.size() - 1);

            // skip duplicates
            int idx = i + 1;
            while (idx < nums.length && nums[idx] == nums[idx - 1]) {
                idx++;
            }

            // exclude
            getAllSubsets(nums, ans, idx, allSubsets);
        }

        public static List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> allSubsets = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();

            getAllSubsets(nums, ans, 0, allSubsets);

            return allSubsets;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 2};

            List<List<Integer>> result = subsetsWithDup(nums);

            for (List<Integer> subset : result) {
                System.out.println(subset);
            }
        }
    }