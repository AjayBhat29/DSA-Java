/* Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 10^4
s consists of English letters, digits, symbols and spaces. */

class Solution {
    public int lengthOfLongestSubstring(String s) {
       // return cubicSolution(s.trim());
       // return squaredSolution(s.trim());
        return optimal(s);
    }
    /*-----------CUBIC SOLUTION-----------------*/
    int cubicSolution(String s)
    {
        int n=s.length();
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(isUnique(s,i,j))
                   max=Math.max(max,j-i+1); 
            }
        }
        return max;
    }
    boolean isUnique(String s,int i,int j)
    {
        boolean visited[]=new boolean[256];
        for(int k=i;k<=j;k++)
        {
            if(visited[s.charAt(k)-'a']==true)
                return false;
            visited[s.charAt(k)-'a']=true;
        }
        return true;
    }
    /*-------End of Cubic Solution---------*/
    /*--------SQUARED SOLUTION--------------*/
    int squaredSolution(String s)
    {
        int n=s.length();
        int max=0;
        for(int i=0;i<n;i++)
        {
            boolean visited[]=new boolean[256];
            for(int j=i;j<n;j++)
            {
                if(visited[s.charAt(j)-'a']==true)
                    break;
                else
                {
                    visited[s.charAt(j)-'a']=true;
                    max=Math.max(max,j-i+1);
                }
            }
            visited[s.charAt(i)-'a']=false;
        }
        return max;
    }
    /*---------End of Sqaured Solution--------*/
    //----------OPTIMAL Solution---------------
    int optimal(String s)
    {
        int i=0,j=0;
        int n=s.length();
        int max=0;
        Set<Character> hset=new HashSet<>();
        while(i<n && j<n)
        {
            if(!hset.contains(s.charAt(j)))
            {
                hset.add(s.charAt(j));
                j++;
                max=Math.max(max,j-i);
            }
            else
            {
                hset.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
