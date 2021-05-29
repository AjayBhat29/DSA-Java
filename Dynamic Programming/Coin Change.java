/* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Example 4:
Input: coins = [1], amount = 1
Output: 1

Example 5:
Input: coins = [1], amount = 2
Output: 2
 

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4 */

// Recursion + Memoization = Top Down DP

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        int ans = topDown(amount, coins, dp);
        return ans >= 10001 ? -1 : ans;
    }

    int topDown(int amount, int[] coins, int[] dp) {
        if (amount == 0)
            return 0;
        if (dp[amount] != -1)
            return dp[amount];
        int min = 10001;
        for (int x : coins) {
            if (amount - x >= 0) {
                dp[amount - x] = topDown(amount - x, coins, dp);
                min = Math.min(min, dp[amount - x]);
            }
        }
        dp[amount] = min + 1;
        return dp[amount];
    }
}

// ----------------------------------------------------------------------------------------
// Bottom Up DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = 10001;
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                min = Math.min(min, dp[i - coin]);
            }
            dp[i] = min + 1;
        }
        return dp[amount] >= 10001 ? -1 : dp[amount];
    }
}