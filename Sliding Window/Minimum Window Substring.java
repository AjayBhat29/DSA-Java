/* Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Example 2:
Input: s = "a", t = "a"
Output: "a"

Constraints:
1 <= s.length, t.length <= 10^5
s and t consist of English letters. */

class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> hmap=new HashMap<>();
        for(char c:t.toCharArray())
            hmap.put(c,hmap.getOrDefault(c,0)+1);
        int count=hmap.size();
        int n=s.length(),i=0,j=0;
        String ans="";
        int min=Integer.MAX_VALUE;
        
        while(j<n)
        {
            char s_j=s.charAt(j);
            char s_i=s.charAt(i);
            
            if(hmap.containsKey(s_j))
            {
                int freq=hmap.get(s_j);
                freq--;
                hmap.put(s_j,freq);
                if(freq==0)
                    count--;
            }
            while(count==0)
            {
                String x=s.substring(i,j+1);
                if(x.length()<min)
                {
                    ans=x;
                    min=ans.length();
                }
                char c=s.charAt(i);
                if(hmap.containsKey(c))
                {
                    int freq=hmap.get(c);
                    freq++;
                    hmap.put(c,freq);
                    if(freq==1)
                        count++;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
