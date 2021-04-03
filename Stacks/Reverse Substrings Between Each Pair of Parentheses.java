/* You are given a string s that consists of lower case English letters and brackets. 
Reverse the strings in each pair of matching parentheses, starting from the innermost one.
Your result should not contain any brackets.

Example 1:
Input: s = "(abcd)"
Output: "dcba"

Example 2:
Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.

Example 3:
Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

Example 4:
Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
 
Constraints:
0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced. */

class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        char a[]=s.toCharArray();
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i]=='(')
                stack.push(i);
            else if(a[i]==')')
            {
                int prev=stack.pop();
                reverse(a,prev,i);
            }
        }
        StringBuilder ans=new StringBuilder();
        for(char c: a)
            if(c!='(' && c!=')')
                ans.append(c);
        return ans.toString();
    }
    void reverse(char a[],int l,int r)
    {
        while(l<r)
        {
            char t=a[l];
            a[l]=a[r];
            a[r]=t;
            l++;
            r--;
        }
    }
}
