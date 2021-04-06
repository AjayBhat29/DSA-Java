/* Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Constraints:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000]. */

// Sorting
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                return true;
        }
        return false;
    }
    public String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}

//Sliding Window
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int hmap[]=new int[26];
        boolean exists[]=new boolean[26];
        for(char c:s1.toCharArray())
        {
            hmap[c-'a']++;
            exists[c-'a']=true;
        }
        int count=0;
        for(boolean x:exists)
            if(x)
                count++;
        int k=s1.length();
        
        int i=0,j=0,n=s2.length();
        while(j<n)
        {
            int s_i=s2.charAt(i)-'a';
            int s_j=s2.charAt(j)-'a';
            
            if(exists[s_j])
            {
                int freq=hmap[s_j];
                freq--;
                hmap[s_j]=freq;
                if(freq==0)
                    count--;
            }
            
            if(j-i+1<k)
                j++;
            else
            {
                if(count==0)
                    return true;
                if(exists[s_i])
                {
                    int freq=hmap[s_i];
                    freq++;
                    hmap[s_i]=freq;
                    if(freq==1)
                        count++;
                }
                i++;
                j++;
            }
        }
        return false;
    }
}
