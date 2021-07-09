/* Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.

(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)

Example 1:
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
 
Note:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters. */

class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        String lcs = LCS(s1, s2);

        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();

        for (char c : lcs.toCharArray()) {
            while (s1.charAt(i) != c)
                ans.append(s1.charAt(i++));
            while (s2.charAt(j) != c)
                ans.append(s2.charAt(j++));
            ans.append(c);
            i++;
            j++;
        }

        ans.append(s1.substring(i));
        ans.append(s2.substring(j));

        return ans.toString();
    }

    String LCS(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder lcs = new StringBuilder();

        int i = n1, j = n2;
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i][j - 1])
                j--;
            else if (dp[i][j] == dp[i - 1][j])
                i--;
            else {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            }
        }

        return lcs.reverse().toString();
    }
}
