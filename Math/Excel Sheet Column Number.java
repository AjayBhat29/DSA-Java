/*
Given a string S that represents column title of an Excel sheet, find the number that represents that column.
In excel A column is number 1, AA is 27 and so on.
*/

class Solution {
    public int titleToNumber(String s) {
        int i;
        int answer=0;
        for(i=0;i<s.length();i++)
        {
            answer= answer*26 + s.charAt(i)-64;
        }
        return answer;
    }
}



/*
===================================================================
*/

/* Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
*/

class Solution {
    public String convertToTitle(int n) {
        int temp=n;
        StringBuilder ans=new StringBuilder();
        while(temp>0)
        {
            temp--;
            int ch=temp%26;
            ans.insert(0,(char)(ch+'A'));
            temp/=26;
        }
        return ans.toString();
    }
}
