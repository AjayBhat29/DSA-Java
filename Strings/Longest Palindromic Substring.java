/* Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"
 
Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case) */

class Solution {
    public String longestPalindrome(String s) {
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            
            int l=i-1,r=i+1;
            
            while(l>=0 && s.charAt(l)==s.charAt(i))
                l--;
            
            while(r<s.length() && s.charAt(i)==s.charAt(r))
                r++;
            
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            
            if(end-start<r-l-1){
                start=l+1;
                end=r-1;
            }
        }
        return s.substring(start,end+1);
    }
}
