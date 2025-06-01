import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    static Set<List<Integer>> set = new HashSet<>();

    public static void getAllCombinations(int arr[], int idx, int target, List<List<Integer>> ans, List<Integer> combin) {
        // base case 
        if (idx == arr.length || target < 0) {
            return;
        }

        if (target == 0) {
            if (!set.contains(new ArrayList<>(combin))) {
                set.add(new ArrayList<>(combin));
                ans.add(new ArrayList<>(combin));  // Add to result
            }
            return;
        }

        // include current number (single or multiple times)
        combin.add(arr[idx]);
        getAllCombinations(arr, idx + 1, target - arr[idx], ans, combin);  // single choice
        getAllCombinations(arr, idx, target - arr[idx], ans, combin);      // multiple choice
        combin.remove(combin.size() - 1); // backtrack

        // exclude current number
        getAllCombinations(arr, idx + 1, target, ans, combin);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        set.clear(); // clear static set to avoid stale data
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();
        getAllCombinations(arr, 0, target, ans, combin);
        return ans;
    }
}
