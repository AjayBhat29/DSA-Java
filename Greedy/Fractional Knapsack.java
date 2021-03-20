/* One day some guests came to Aman's home. 
Aman's mama told him to bring N items from the market and gave him a bag, but the bag can hold a maximum weight of W units. 
Every item has some weight wi and a value vi. Aman has to put these items in the bag such that the total value is maximized.

Note:Aman can break items for maximizing the total value of the bag.

Input
The first line consists of two integers N and W, denoting the number of items and capacity of bag respectively.
Next N lines contains value vi and weight wi seprated by space.

Output
Print the maximum possible value(Round off if the answer is in decimal).

Constarints
1<=N<=10^4

1<=W<=10^4

1<=vi<=10^3

1<=wi<=10^3

Time Limit 1 second

Sample Input
3 30
30 8
40 5
60 20

Sample Output
121 */

static class Task {
		public void solve(int testNumber, FastReader scan, PrintWriter out) {
			int N = scan.nextInt();
			int W = scan.nextInt();
			ArrayList<Pair> al = new ArrayList<>();
			for (int i = 0; i < N; i++)
				al.add(new Pair(scan.nextDouble(), scan.nextDouble()));
			Collections.sort(al);
			// out.println(al);
			double total_weight = 0;// weight
			double profit = 0;
			int i = 0;
			while (i < N) {
				Pair p = al.get(i);
				if (total_weight + p.weight <= W) {
					total_weight += p.weight;
					profit += p.v_per_w * p.weight;
				} else {
					double weight_needed = W - total_weight;
					profit += weight_needed * p.v_per_w;
					total_weight = W;
				}
				if (total_weight == W)
					break;
				i++;
			}
			out.println(Math.round(profit));
		}
	}

	static class Pair implements Comparable<Pair> {
		double value;
		double weight;
		double v_per_w;

		public Pair(double v, double w) {
			this.value = v;
			this.weight = w;
			v_per_w = v / w;
		}

		public int compareTo(Pair other) {
			if (this.v_per_w < other.v_per_w)
				return 1;
			else
				return -1;
		}

		public String toString() {
			return "[" + value + ", " + weight + ", " + v_per_w + "]";
		}
	}
