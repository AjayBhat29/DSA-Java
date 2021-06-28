public class Solution {
    List<Integer> rangeSumQuery(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = nums[i] + prefixSum[i - 1];

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            ans.add(prefixSum[right] - prefixSum[left] + nums[left]);
        }
        return ans;
    }
}