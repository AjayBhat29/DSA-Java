/* Himanshu now wants to become the king. He has N persons to defeat before he can become the King. 
He can choose any two persons and can fight with them, the strength needed for this is equal to the sum of both the persons. 
But whenever two persons are defeated they get killed and a new person borns with the combined strength of two person defeated. 
The fight continues until there is only one person left.
Help Himanshu find the minimum strength he should waste to become king.

Input format
The first line contains an integer T, denoting the number of test cases.
For each test case:
The first line contains an integer N.The second line contains N space separated integers. 

Output format
For every test case on a new line print one integer, the minimum strength Himanshu should waste to become king. 

Constraints
1<=T<=10
1<=N<=1000

Time Limit 1 second

Example
Input
1
3
2 3 4

Output
14

Sample test case Explanation
Himanshu defeats 2,3 so the list of opponents becomes 5,4 then Himanshu defeats them.So the strength required is (2+3)+(5+4)=14. */

static class Task {
		public void solve(int testNumber, FastReader scan, PrintWriter out) {
			int n = scan.nextInt();
			if (n == 1) {
				int x = scan.nextInt();
				out.println(x);
				return;
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++)
				pq.add(scan.nextInt());
			long total = 0;
			while (pq.size() >= 2) {
				int a = pq.remove();
				int b = pq.remove();
				total += a + b;
				pq.add(a + b);
			}
			out.println(total);
		}
	}
