//codebix
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = expression.substring(0, i);  // Fixed: subString → substring
                String b = expression.substring(i + 1); // Fixed: subString → substring

                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);

                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }

        // If no operators were found, parse the number directly
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }

        return res;
    }
}
