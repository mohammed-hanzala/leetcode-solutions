import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(
        int n,
        int open,
        int close,
        StringBuilder current,
        List<String> result
    ) {
        // A complete valid combination is formed
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add an opening parenthesis
        if (open < n) {
            current.append('(');

            backtrack(n, open + 1, close, current, result);

            current.deleteCharAt(current.length() - 1);
        }

        // Add a closing parenthesis only when valid
        if (close < open) {
            current.append(')');

            backtrack(n, open, close + 1, current, result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}