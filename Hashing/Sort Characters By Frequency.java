/* Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer. */

class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> hmap=new HashMap<>();
        for(char c:s.toCharArray())
        {
            hmap.put(c,hmap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();        
        for(char c: hmap.keySet())
        {
            Pair p=new Pair(c,hmap.get(c));
            pq.add(p);
        }
        StringBuilder ans=new StringBuilder();
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            int x=p.val;
            while(x-->0)
                ans.append(p.key);
        }
        return ans.reverse().toString();
    }
}

class Pair implements Comparable<Pair>
{
    char key;
    int val;
    Pair(char key,int val)
    {
        this.key=key;
        this.val=val;
    }
    
    public int compareTo(Pair other)
    {
        return this.val-other.val;
    }
}
