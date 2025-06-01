//by code shash recursion and backtracking

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates); // sort the candidates to handle duplicates
        recur(candidates, target, 0, cur, res);
        return res;
    }

    public void recur(int[] candidates, int target, int ind, ArrayList<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur)); // base case
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue; // skip duplicates
            }
            if (candidates[i] > target) {
                break; // no need to continue if candidate exceeds target
            }
            cur.add(candidates[i]);
            recur(candidates, target - candidates[i], i + 1, cur, res);
            cur.remove(cur.size() - 1); // backtrack
        }
    }
}
