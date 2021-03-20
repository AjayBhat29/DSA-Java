/* Every positive fraction can be represented as sum of unique unit fractions. A fraction is unit fraction if numerator is 1 and denominator is a positive integer, for example 1/3 is a unit fraction. Such a representation is called Egyptian Fraction as it was used by ancient Egyptians.
Following are few examples:
Egyptian Fraction Representation of 2/3 is 1/2 + 1/6
Egyptian Fraction Representation of 6/14 is 1/3 + 1/11 + 1/231
Egyptian Fraction Representation of 12/13 is 1/2 + 1/3 + 1/12 + 1/156 */

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		FastReader scan = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		Task solver = new Task();
		ans = new StringBuilder();
		int T = scan.nextInt();
		for (int tt = 0; tt < T; tt++)
			solver.solve(tt, scan, out);
		out.print(ans);
		out.close();
	}

	static StringBuilder ans;

	static class Task {
		public void solve(int testNumber, FastReader scan, PrintWriter out) {
			int nr = scan.nextInt();
			int dr = scan.nextInt();
			fraction(nr, dr);
			ans.append("\n");
		}

		//<-------------------------------------------- Function Implementations below--------------------------------------->
		void fraction(int nr, int dr) {
			if (nr == 0 || dr == 0)
				return;
			if (nr % dr == 0) {
				ans.append(nr / dr + " ");
				return;
			}
			if (dr % nr == 0) {
				ans.append("1/" + dr / nr + " ");
				return;
			}
			if (nr > dr) {
				ans.append(nr / dr + " ");
				fraction(nr % dr, dr);
				return;
			}
			int k = (int) Math.ceil((double) dr / nr);
			ans.append("1/" + k + " ");
			fraction(nr * k - dr, dr * k);
		}
		//<-------------------------------------------Function Implementations above------------------------------------------>
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}