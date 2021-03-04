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
        Stack<Character> st=new Stack<>();
        boolean flag=false;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='{'||ch=='['||ch=='(')
                st.push(ch);
            else
            {
                if(st.empty())
                {
                    flag=true;
                    break;
                }
                else if(ch==')' && st.pop()!='(')
                {
                    flag=true;
                    break;
                }
                else if(ch==']' && st.pop()!='[')
                {
                    flag=true;
                    break;
                }
                else if(ch=='}' && st.pop()!='{')
                {
                    flag=true;
                    break;
                }
            }
        }
        if(st.empty() && !flag)
            return true;
        return false;
    }
}
