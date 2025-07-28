//codebix
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        findAllPermutations(res, s.toCharArray(), 0);
        return res;
    }

    public void findAllPermutations(List<String> res, char[] chars, int index) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }

        if (Character.isLetter(chars[index])) {
            // Lowercase path
            chars[index] = Character.toLowerCase(chars[index]);
            findAllPermutations(res, chars, index + 1);

            // Uppercase path
            chars[index] = Character.toUpperCase(chars[index]);
            findAllPermutations(res, chars, index + 1);
        } else {
            // If it's a digit, just proceed
            findAllPermutations(res, chars, index + 1);
        }
    }
}
