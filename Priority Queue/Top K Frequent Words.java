/* Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters. */

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<String,Integer> hmap=new HashMap<>();
        for(String str: words)
            hmap.put(str,hmap.getOrDefault(str,0)+1);
        for(String str: hmap.keySet())
        {
            int x=hmap.get(str);
            Pair p=new Pair(str,x);
            pq.add(p);
        }
        List<String> al=new LinkedList<>();
        while(k-->0)
        {
            al.add(pq.poll().word);
        }
        return al;
    }
}

class Pair implements Comparable<Pair>
{
    String word;
    int freq;
    Pair(String word,int freq)
    {
        this.word=word;
        this.freq=freq;
    }
    
    public int compareTo(Pair other)
    {
        int first=other.freq-this.freq;
        if(first!=0)
            return first;
        return this.word.compareTo(other.word);
    }
}