/* Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 
Constraints:
1 <= s.length <= 1000
s consists only of lowercase English letters. */

class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[s.length()][s.length()];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return topDownLCS(s, r, 0, 0, dp);
    }

    int topDownLCS(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + topDownLCS(s1, s2, i + 1, j + 1, dp);
            return dp[i][j];
        }
        int x = topDownLCS(s1, s2, i + 1, j, dp);
        int y = topDownLCS(s1, s2, i, j + 1, dp);
        dp[i][j] = Math.max(x, y);
        return dp[i][j];
    }
}
