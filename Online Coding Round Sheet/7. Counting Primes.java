import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        List<Integer> primes = getPrimes(10000000);
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int ind1 = binarySearch(primes, 0, primes.size() - 1, m, true);
            int ind2 = binarySearch(primes, 0, primes.size() - 1, n, false);
            ans.append((ind2 - ind1 + 1) + "\n");
        }
        System.out.print(ans);
    }

    static List<Integer> getPrimes(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        for (int i = 2; i * i <= n; i++) {
            if (arr[i] == true) {
                for (int j = i * i; j <= n; j = j + i)
                    arr[j] = false;
            }
        }
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (arr[i] == true)
                prime.add(i);
        return prime;
    }

    static int binarySearch(List<Integer> l, int lo, int hi, int target, boolean f) {
        int ans1 = 0, ans2 = l.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (l.get(mid) == target)
                return mid;
            if (l.get(mid) > target) {
                ans1 = mid;
                hi = mid - 1;
            } else {
                ans2 = mid;
                lo = mid + 1;
            }
        }
        if (f)
            return ans1;
        else
            return ans2;
    }
}
