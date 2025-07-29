//optimised code using dp  gpt
import java.util.*;

class Solution {
    HashSet<String> set;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;

        set = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            if (word.length() == 0) continue;
            set.remove(word); // avoid using the word itself
            if (isConcat(word)) {
                res.add(word);
            }
            set.add(word); // restore for next iteration
        }

        return res;
    }

    private boolean isConcat(String word) {
        int len = word.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }
}
