public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        int lo = Integer.MAX_VALUE, hi = 0;
        for (int x : A) {
            lo = Math.min(lo, x);
            hi += x;
        }
        if (A.size() < B)
            return -1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(A, B, mid)) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }

    boolean isPossible(ArrayList<Integer> A, int B, int limit) {
        int allotted = 1, pages = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > limit)
                return false;
            if (pages + A.get(i) > limit) {
                pages = A.get(i);
                allotted++;
            } else
                pages += A.get(i);
        }
        return allotted <= B;
    }
}
