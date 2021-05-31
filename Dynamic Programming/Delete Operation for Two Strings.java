/* Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Example 1:
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Example 2:
Input: word1 = "leetcode", word2 = "etco"
Output: 4
 
Constraints:
1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters. */

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        int lcs = topDownLCS(word1, word2, 0, 0, dp);
        return word1.length() + word2.length() - 2 * lcs;
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
