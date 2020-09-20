/* Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order. */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int x: nums)
          hmap.put(x,hmap.getOrDefault(x,0)+1);
        int []sol=new int[k];
        int i=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry: hmap.entrySet())
        {
            Pair p=new Pair(entry.getKey(),entry.getValue());
            pq.add(p);
            if(pq.size()>k)
                pq.poll();
        }
        while(k-->0)
        {
            Pair p=pq.poll();
            sol[k]=p.key;
        }
        return sol;
    }
}

class Pair implements Comparable<Pair>
{
   int key;
   int v;
   
   Pair(int key,int v)
   {
      this.key=key;
      this.v=v;
   }
   
   public int compareTo(Pair other)
   {
     return this.v-other.v;
   }
}