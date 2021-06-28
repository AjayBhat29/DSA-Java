class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int local = localInversions(nums);
        int global = globalInversions(nums);
        return local == global;
    }

    int localInversions(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i + 1])
                ans++;
        return ans;
    }

    int globalInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return 0;
        int mid = lo + (hi - lo) / 2;
        int inv = mergeSort(nums, lo, mid);
        inv += mergeSort(nums, mid + 1, hi);
        inv += merge(nums, lo, mid, hi);
        return inv;
    }

    int merge(int[] nums, int lo, int mid, int hi) {
        int ans = 0;
        int i = lo, j = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j])
                temp.add(nums[i++]);
            else {
                ans += mid - i + 1;// inversion counting step
                temp.add(nums[j++]);
            }
        }
        while (i <= mid)
            temp.add(nums[i++]);
        while (j <= hi)
            temp.add(nums[j++]);
        int ind = 0;
        for (i = lo; i <= hi; i++)
            nums[i] = temp.get(ind++);

        return ans;// return the number of inversions
    }
}
