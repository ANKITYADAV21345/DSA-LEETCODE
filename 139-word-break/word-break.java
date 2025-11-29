
//recursive +memoised 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return solve(s, 0, set, memo);
    }

    private boolean solve(String s, int start, Set<String> set, Boolean[] memo) {
        // if we reached the end => successful segmentation
        if (start == s.length()) {
            return true;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String part = s.substring(start, end);
            if (set.contains(part) && solve(s, end, set, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}
