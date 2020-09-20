/* Given N numbers in an array. Your task is to keep at-most K numbers at the top (According to their frequency).  We basically need to print top k numbers when input stream has included k distinct elements, else need to print all distinct elements sorted by frequency.

Example 1:

Input:
N=5, K=4
arr[] = {5, 2, 1, 3, 2} 
Output: 5 2 5 1 2 5 1 2 3 5 2 1 3 5 
Explanation:
Firstly their was 5 whose frequency
is max till now. so print 5.
Then 2 , which is smaller than 5 but
their frequency is same so print 2 5.
Then 1, which is smallet among all the
number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5
Then again 2, which has the highest
frequency among all number so 2 1 3 5. */

class Solution
{ 
    static ArrayList<Integer> kTop(int[] a, int n, int k) 
    { 
        ArrayList<Integer> al=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Map<Integer,Integer> hmap=new HashMap<>();
        for(int x:a)
        {
            hmap.put(x,hmap.getOrDefault(x,0)+1);
            for(Map.Entry<Integer,Integer> entry: hmap.entrySet())
            {
                Pair ob=new Pair(entry.getKey(),entry.getValue());
                pq.add(ob);
            }
            int size=Math.min(k,pq.size());
            while(size-->0)
            {
                Pair ob=pq.poll();
                al.add(ob.key);
            }
            pq.clear();
        }
        return al;
    }
}

class Pair implements Comparable<Pair>
{
    int key;
    int value;
    Pair(int key,int value)
    {
        this.key=key;
        this.value=value;
    }
    
    public int compareTo(Pair other)
    {
        //first(to give priority on the basis of frequency)
        int first=other.value-this.value;
        if(first!=0)
            return first;
        // if same frequency, then give priority based on ascending order
        return this.key-other.key;
    }
}