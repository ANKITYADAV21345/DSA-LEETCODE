import java.util.*;

class Solution {
    HashSet<String> set;
    HashMap<String, Boolean> memo;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;

        set = new HashSet<>(Arrays.asList(words));
        memo = new HashMap<>();

        for (String word : words) {
            if (word.length() == 0) continue;

            set.remove(word);  // avoid using itself

            if (isConcat(word)) {
                res.add(word);
            }

            set.add(word); // add it back
        }

        return res;
    }

    private boolean isConcat(String word) {
        if (memo.containsKey(word))
            return memo.get(word);

        // Try splitting the word into prefix + suffix
        for (int i = 1; i < word.length(); i++) {

            String left = word.substring(0, i);
            String right = word.substring(i);

            // If prefix exists and suffix is concatenated recursively
            if (set.contains(left) && (set.contains(right) || isConcat(right))) {
                memo.put(word, true);
                return true;
            }
        }

        memo.put(word, false);
        return false;
    }
}
