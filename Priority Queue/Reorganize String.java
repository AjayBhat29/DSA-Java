/* Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:
Input: S = "aab"
Output: "aba"

Example 2:
Input: S = "aaab"
Output: ""

Note:
S will consist of lowercase letters and have length in range [1, 500]. */

class Solution {
    public String reorganizeString(String S) {
        int n=S.length();
        if(n==1)
            return S;
        Map<Character,Integer> hmap=new HashMap<>();
        for(char c:S.toCharArray())hmap.put(c,hmap.getOrDefault(c,0)+1);
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(char c:hmap.keySet())pq.add(new Pair(c,hmap.get(c)));
        StringBuilder ans=new StringBuilder();
        while(pq.size()>=2)
        {
            Pair one=pq.poll();
            Pair two=pq.poll();
            ans.append(one.val);
            ans.append(two.val);
            one.freq--;
            two.freq--;
            if(one.freq>0)pq.add(one);
            if(two.freq>0)pq.add(two);
        }
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            if(p.freq>1)
                return "";
            ans.append(p.val);
        }
        return ans.toString();
    }
}

class Pair implements Comparable<Pair>
{
    char val;
    int freq;
    public Pair(char val,int freq)
    {
        this.val=val;
        this.freq=freq;
    }
    
    public int compareTo(Pair other)
    {
        return other.freq-this.freq;
    }
}
