/* Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

Example 1:
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.

Example 2:
Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 
Constraints:
1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique. */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        Pair[] dp = new Pair[n];
        dp[0] = new Pair(0, 1);

        int max_index = 0;
        int max_count = -1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            int index = i;

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (max < dp[j].count) {
                        max = dp[j].count;
                        index = j;
                    }
                }
            }

            dp[i] = new Pair(index, max + 1);
            if (max_count < dp[i].count) {
                max_count = dp[i].count;
                max_index = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int i = max_index;
        boolean[] visited = new boolean[n + 1];
        while (i >= 0 && !visited[i]) {
            visited[i] = true;
            stack.push(nums[i]);
            i = dp[i].index;
        }

        List<Integer> ans = new ArrayList<>();
        while (!stack.empty())
            ans.add(stack.pop());
        return ans;
    }
}

class Pair {
    int index;
    int count;

    Pair(int i, int c) {
        this.index = i;
        this.count = c;
    }
}
