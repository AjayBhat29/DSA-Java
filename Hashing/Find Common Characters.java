/* Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
 

Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter */

class Solution {
    public List<String> commonChars(String[] A) {
        int n=A.length;  
        int result[] = new int[26];
        Arrays.fill(result,100);
        for(int i=0;i<n;i++)
        {
            int a[]=new int[26];
            for(int j=0;j<A[i].length();j++)
                a[(int)(A[i].charAt(j)-'a')]++;
            for(int j=0;j<26;j++)
                result[j]=Math.min(result[j],a[j]);
        }
        List<String> ans=new LinkedList<>();
        for(int i=0;i<26;i++)
        {
            while(result[i]-->0)
                ans.add(String.valueOf((char)(i+'a')));
        }
        return ans;
    }
}