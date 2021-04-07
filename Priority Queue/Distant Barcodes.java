/* In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.

Example 1:
Input: barcodes = [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]

Example 2:
Input: barcodes = [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,1,2,1,2]
 
Constraints:
1 <= barcodes.length <= 10000
1 <= barcodes[i] <= 10000 */

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n=barcodes.length;
        if(n==1)
            return barcodes;
        int sol[]=new int[n];
        int pos=0;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int x:barcodes)
            hmap.put(x,hmap.getOrDefault(x,0)+1);
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int x:hmap.keySet())
            pq.add(new Pair(x,hmap.get(x)));
        while(pq.size()>=2)
        {
            Pair one=pq.poll();
            Pair two=pq.poll();
            sol[pos++]=one.value;
            sol[pos++]=two.value;
            one.freq--;
            two.freq--;
            if(one.freq>0)
                pq.add(one);
            if(two.freq>0)
                pq.add(two);
        }
        while(!pq.isEmpty())
            sol[pos++]=pq.poll().value;
        return sol;
    }
}

class Pair implements Comparable<Pair>
{
    int value;
    int freq;
    public Pair(int value,int freq)
    {
        this.value=value;
        this.freq=freq;
    }
    
    public int compareTo(Pair other)
    {
        return other.freq-this.freq;
    }
}
