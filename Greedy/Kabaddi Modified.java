/* Arnab has made a team and he wants to fight with another team with some modified form of Kabaddi. 
In this game, all the players stand in a line. Now in a turn Arnab's team member can hold and win over an player of opposite team upto 
K distance apart. Each player of Arnab's team can win over only one opponent player and upto K distance. 
 Player of Arnab's team is marked by 1 and opponents team is marked by 0.
Find the maximum number of people Arnab's team can win over.

Input format
The first line contains an integer T, denoting the number of test cases.
Each test case contains a string S of 0 and 1 and another integer K.

Output format
For every testcase on a line print the maximum number of wins.

Constraints
1<=T<=10
1<=|S|<=10000
1<=K<=100

Time Limit 1 second

Example
Input
1
101001 3

Output
3

Sample test case Explanation
First player can win over 2nd player,3rd player can win over 4th player and last player can win over 2nd last player. */

static class Task {
		public void solve(int testNumber, FastReader scan, PrintWriter out) {
			String s = scan.next();
			int k = scan.nextInt();
			char a[] = s.toCharArray();
			int count = 0;
			int n = a.length;
			for (int i = 0; i < n; i++) {
				if (a[i] == '1') {
					for (int j = Math.max(i - k, 0); j <= Math.min(n - 1, i + k); j++) {
						if (a[j] == '0') {
							a[j] = '2';
							count++;
							break;
						}
					}
				}
			}
			out.println(count);
		}
	}
