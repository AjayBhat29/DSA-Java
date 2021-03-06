/* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 
Constraints:
0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters. */

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word2.length() + 1][word1.length() + 1];
        for (int i = 0; i <= word2.length(); i++) {
            for (int j = 0; j <= word1.length(); j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 0; // no strings given
                else if (i == 0 && j != 0) {
                    dp[i][j] = j; // word2 is empty
                } else if (i != 0 && j == 0) {
                    dp[i][j] = i; // word1 is empty
                } else if (word2.charAt(i - 1) != word1.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1]; // same characters just carry over previous cost
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }
}
