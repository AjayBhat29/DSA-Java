class Solution {
	// Function to convert an infix expression to a postfix expression.
	public static String infixToPostfix(String exp) {
		// Your code here
		StringBuilder ans = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (char c : exp.toCharArray()) {
			if (isOperator(c)) {
				if (stack.empty() || stack.peek() == '(' || isLowerPrecedence(stack.peek(), c))
					stack.push(c);
				else {
					while (!stack.empty() && stack.peek() != '(' && !isLowerPrecedence(stack.peek(), c))
						ans.append(stack.pop());
					stack.push(c);
				}
			} else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				while (!stack.empty() && stack.peek() != '(')
					ans.append(stack.pop());
				stack.pop();
			} else
				ans.append(c);
		}
		while (!stack.empty())
			ans.append(stack.pop());
		return ans.toString();
	}

	static boolean isLowerPrecedence(char top, char ch) {
		if (ch == '^')
			return true;
		else if (ch == '*' || ch == '*')
			return top == '+' || top == '-';
		else if (ch == '+' || ch == '-')
			return false;
		return false;
	}

	static boolean isOperator(char c) {
		return c == '^' || c == '*' || c == '/' || c == '+' || c == '-';
	}
}
