/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000 */

//Method 1
class Solution {
    public String convert(String s, int R) {
        char a[][]=new char[R][1001];
        int k=0;
        int n=s.length();
        int c=0;
        while(k<n)
        {
            for(int i=0;i<R;i++)
            {
                if(k<n)
                    a[i][c]=s.charAt(k++);
                if(k>=n)
                    break;
            }
            c++;
            if(k>=n)
                break;
            for(int i=R-2;i>0;i--)
            {
                if(k<n)
                    a[i][c++]=s.charAt(k++);
            }
            if(k>=n)
                break;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<c;j++)
                if(a[i][j]!='\0')
                    ans.append(a[i][j]);
        }
        return ans.toString();
    }
}

//Method 2
class Solution {
    public String convert(String s, int R) {
       if(R==1)
           return s;
        
        List<StringBuilder> l=new ArrayList<>();
        for(int i=0;i<R;i++)
            l.add(new StringBuilder());
        
        boolean goingDown=false;
        int row=0;
        for(char c:s.toCharArray())
        {
            l.get(row).append(c);
            if(row==0 || row==R-1)
                goingDown=!goingDown;
            row+=goingDown?1:-1;
        }
        
        StringBuilder ans=new StringBuilder();
        for(StringBuilder sb:l)
            ans.append(sb);
        return ans.toString();
    }
}
