//tabulationn 
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);

        // dp[i] stores all valid sentences from index i
        List<String>[] dp = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++)
            dp[i] = new ArrayList<>();

        dp[n].add(""); // empty string is a valid suffix

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                String prefix = s.substring(i, j);
                if (dict.contains(prefix)) {
                    for (String sentence : dp[j]) {
                        dp[i].add(sentence.isEmpty() ? prefix : prefix + " " + sentence);
                    }
                }
            }
        }

        return dp[0];
    }
}
