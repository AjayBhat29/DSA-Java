/* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:
Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:
Input: s = "acdcb", p = "a*c?b"
Output: false
 
Constraints:
0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'. */

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        return isMatch(s, p, 0, 0, dp);
    }

    boolean isMatch(String s, String p, int i, int j, int[][] dp) {
        if (i == s.length() && j == p.length())
            return true;
        if (i == s.length() && onlyStar(p, j))
            return true;
        if (i == s.length() || j == p.length())
            return false;
        if (dp[i][j] != 0)
            return dp[i][j] == 1;

        boolean result = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            result = isMatch(s, p, i + 1, j + 1, dp);
        else if (p.charAt(j) == '*')
            result = isMatch(s, p, i + 1, j, dp) || isMatch(s, p, i, j + 1, dp) || isMatch(s, p, i + 1, j + 1, dp);
        else
            result = false;

        dp[i][j] = result ? 1 : -1;
        return result;
    }

    boolean onlyStar(String p, int j) {
        while (j < p.length()) {
            if (p.charAt(j) != '*')
                return false;
            j++;
        }
        return true;
    }
}
