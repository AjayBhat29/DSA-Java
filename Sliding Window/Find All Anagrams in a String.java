/* Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab". */

// Brute
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=p.length();
        List<Integer> l=new ArrayList<>();
        char a[]=p.toCharArray();
        Arrays.sort(a);
        String pat=new String(a);
        for(int i=0;i<s.length()-n+1;i++)
        {
            a=s.substring(i,i+n).toCharArray();
            Arrays.sort(a);
            String x=new String(a);
            if(x.equals(pat))
                l.add(i);
        }
        return l;
    }
}

//Sliding Window 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> hmap=new HashMap<>();
        for(char c:p.toCharArray())
            hmap.put(c,hmap.getOrDefault(c,0)+1);
        int count=hmap.size();
        int k=p.length();
        
        List<Integer> al=new ArrayList<>();//list containing solution indices
        
        int i=0,j=0,n=s.length();
        while(j<n)
        {
            char s_i=s.charAt(i);
            char s_j=s.charAt(j);
            
            if(hmap.containsKey(s_j))
            {
                int freq=hmap.get(s_j);
                freq--;
                hmap.put(s_j,freq);
                if(freq==0)
                    count--;
            }
            
            if(j-i+1<k)
                j++;
            else
            {
                if(count==0)
                    al.add(i);
                if(hmap.containsKey(s_i))
                {
                    int freq=hmap.get(s_i);
                    freq++;
                    hmap.put(s_i,freq);
                    if(freq==1)
                        count++;
                }
                i++;
                j++;
            }
        }
        return al;
    }
}
