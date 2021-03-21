/* Arnab is playing a game. He is given a number N in string format and now he is asked to remove M digits from the number as a part of the game. 
He wants to return with the maximum value of N possible(Order of digits should not change). Print the maximum value of N.

Input format
The first line contains an integer T, denoting the number of test cases.
Each test case contains a string N and an integer M.

Output format
Print the maximum value of N in a new line.

Constraints:
1<=T<=10
1<=|N|<=1000
1<=M<|N|<1000

Time Limit 1 second

Example
Input
1
421 1

Output
42

Sample test case Explanation
By removing digit 1 we can find the maximum number which is 42 */

static class Task {
		public void solve(int testNumber, FastReader scan, PrintWriter out) {
			String s = scan.next();
			int m = scan.nextInt();
			String answer = "";
			while (m-- > 0) {
				answer = "";
				for (int i = 0; i < s.length(); i++) {
					String a = s.substring(0, i) + s.substring(i + 1);
					if (a.compareTo(answer) > 0)
						answer = a;
				}
				s = answer;
			}
			out.println(answer);
		}
	}
