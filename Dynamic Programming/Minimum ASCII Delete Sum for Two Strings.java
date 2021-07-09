/* Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.

Constraints:
1 <= s1.length, s2.length <= 1000
s1 and s2 consist of lowercase English letters. */


//----------------------------------------------------------------------------------------------------------------
// Top Down
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return topDown(s1, s2, 0, 0, dp);
    }

    int topDown(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() && j == s2.length())// base case - when both strings are empty (nothing more left to
                                                 // process)
            return 0;
        if (i == s1.length()) { // base case - when only string 2 is left to process
            int sum = 0;
            for (; j < s2.length(); j++)
                sum += (int) s2.charAt(j);
            return sum;
        }
        if (j == s2.length()) {// base case - when only string 1 is left to process
            int sum = 0;
            for (; i < s1.length(); i++)
                sum += (int) s1.charAt(i);
            return sum;
        }

        if (dp[i][j] != -1) // if dp[i][j] is not -1
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))// if characters are equal, dont include their ASCIIs for deleting
            dp[i][j] = topDown(s1, s2, i + 1, j + 1, dp);
        else {
            int exlI = topDown(s1, s2, i + 1, j, dp) + (int) s1.charAt(i);// exlcuding ith character from s1
            int exlJ = topDown(s1, s2, i, j + 1, dp) + (int) s2.charAt(j);// exluding jth character from s2
            dp[i][j] = Math.min(exlI, exlJ);// minimum of exlI and exlJ
        }
        return dp[i][j];
    }
}

//--------------------------------------------------------------------------------------------------------------------------
// Bottom Up
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        dp[0][0] = 0;

        dp[0][1] = (int) s2.charAt(0);
        for (int j = 2; j <= n2; j++)
            dp[0][j] = dp[0][j - 1] + (int) s2.charAt(j - 1);

        dp[1][0] = (int) s1.charAt(0);
        for (int i = 2; i <= n1; i++)
            dp[i][0] = dp[i - 1][0] + (int) s1.charAt(i - 1);

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int exlI = dp[i - 1][j] + (int) s1.charAt(i - 1);
                    int exlJ = dp[i][j - 1] + (int) s2.charAt(j - 1);
                    dp[i][j] = Math.min(exlI, exlJ);
                }
            }
        }
        return dp[n1][n2];
    }
}
