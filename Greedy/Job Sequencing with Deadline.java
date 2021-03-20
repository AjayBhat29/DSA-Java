/* One day Aman went to the office and his boss gave him some tasks to finish within the given deadline and told him to earn maximum profit. 
Boss gave him a set of N task where each task i has a deadline and profit associated with it. 
Each task takes 1 unit of time to complete and only one job can be scheduled at a time. 
Aman can earn the profit if and only if the job is completed by its deadline. 
Aman has to find the maximum profit but he doesn't know how to maximize profit so he asks for your help.

Input:
The first line of input contains an integer N, N denoting the number of tasks.
The next N line consists of task id. 
Deadline and the Profit associated with that Job, all separated by space.

Output:
Print the maximum profit.

Constraints:
1<=N<=10^3
1<=Deadline<=100
1<=Profit<=500

Example
Input
7
1 1 3
2 3 5
3 4 20
4 3 18
5 2 0
6 1 6
7 2 30

Output
74

Explanation:
The first task completed will be task-6 with a profit of 6.
The second task completed will be task-7 with a profit of 30.
The third task completed will be task-4 with a profit of 18.
The last task completed will be task-3 with a profit of 20.
So maximum profit = 6+30+18+20=74. */

static class Task {
		public void solve(int testNumber, FastReader scan, PrintWriter out) {
			int n = scan.nextInt();
			ArrayList<Job> al = new ArrayList<>();
			int profit_values[] = new int[n];
			for (int i = 0; i < n; i++) {
				int j = scan.nextInt() - 1;
				int d = scan.nextInt();
				int p = scan.nextInt();
				profit_values[j] = p;
				al.add(new Job(j, d, p));
			}
			Collections.sort(al);
			// out.println(al);
			int result[] = new int[n];
			boolean slot_filled[] = new boolean[n];
			for (int i = 0; i < n; i++) {
				for (int j = Math.min(n, al.get(i).deadline) - 1; j >= 0; j--) {
					if (slot_filled[j] == false) {
						result[j] = al.get(i).job_id;
						slot_filled[j] = true;
						break;
					}
				}
			}
			int max_profit = 0;
			for (int i = 0; i < n; i++)
				if (slot_filled[i] == true)
					max_profit += profit_values[result[i]];
			out.println(max_profit);
		}
	}

	static class Job implements Comparable<Job> {
		int job_id;
		int deadline;
		int profit;

		public Job(int j, int d, int p) {
			this.job_id = j;
			this.deadline = d;
			this.profit = p;
		}

		public int compareTo(Job other) {
			if (this.profit <= other.profit)
				return 1;
			else
				return -1;
		}

		public String toString() {
			return "[" + job_id + ", " + deadline + ", " + profit + "]";
		}
	}
