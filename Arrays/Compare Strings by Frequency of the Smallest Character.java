/* Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty string s. For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character is 'c', which has a frequency of 2.

You are given an array of strings words and another array of query strings queries. For each query queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.

Return an integer array answer, where each answer[i] is the answer to the ith query.

 

Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 

Constraints:

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] consist of lowercase English letters. */

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int q_len=queries.length;
        int q_score[]=new int[q_len];
        for(int i=0;i<q_len;i++)
        {
            String q=queries[i];
            char arr[]=q.toCharArray();
            char small=arr[0];
            for(int j=0;j<q.length();j++)
            {
                if(small>arr[j])
                    small=arr[j];
            }
            int freq=0;
            for(int j=0;j<q.length();j++)
                if(arr[j]==small)
                    freq++;
            q_score[i]=freq;
        }
        
        int w_len=words.length;
        int []w_score=new int[w_len];
        for(int i=0;i<w_len;i++)
        {
            String w=words[i];
            char arr[]=w.toCharArray();
            char small=arr[0];
            for(int j=0;j<w.length();j++)
            {
                if(small>arr[j])
                    small=arr[j];
            }
            int freq=0;
            for(int j=0;j<w.length();j++)
                if(arr[j]==small)
                    freq++;
            w_score[i]=freq;
        }
        Arrays.sort(w_score);
        
        int sol[]=new int[q_len];
        for(int i=0;i<q_len;i++)
            sol[i]=w_len-bS(w_score,0,w_len-1,q_score[i]);
        return sol;
    }
    int bS(int a[],int lo,int hi,int data)
    {
        if(lo>hi)
            return -1;
        int mid=lo+(hi-lo)/2;
        if(a[mid]<=data)
        {
            if(mid==a.length-1)
                return mid+1;
            if(a[mid+1]>data)
                return mid+1;
            else
                return bS(a,mid+1,hi,data);
        }
        else
        {
            if(mid==0)
                return mid;
            if(a[mid-1]<=data)
                return mid;
            else
                return bS(a,lo,mid-1,data);
        }
    }
}
