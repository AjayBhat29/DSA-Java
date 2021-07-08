/* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{')
                stack.push(c);
            else{
                if(stack.empty())
                    return false;
                char top=stack.pop();
                if(c==']'&&top!='[')return false;
                if(c=='}'&&top!='{')return false;
                if(c==')'&&top!='(')return false;
            }
        }
        if(!stack.empty())return false;
        return true;
    }
}
