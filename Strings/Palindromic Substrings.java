/* Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Note:

The input string length won't exceed 1000. */

class Solution {
    public int countSubstrings(String s) {
        int tot=0;
        for(int i=0;i<s.length();i++)
        {
            tot+=countPalindromeAboutCentre(s,i,i);//odd length palindromes
            tot+=countPalindromeAboutCentre(s,i,i+1);//even length palindromes
        }
        return tot;
    }
    int countPalindromeAboutCentre(String s,int l,int r)
    {
        int ans=0;
        while(l>=0 && r<s.length())
        {
            if(s.charAt(l)!=s.charAt(r))
                return ans;
            l--;
            r++;
            ans++;
        }
        return ans;
    }
}
