/* Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form. */

class Solution {
    public String complexNumberMultiply(String one, String two) {
        StringBuilder a=new StringBuilder();
        StringBuilder b=new StringBuilder();
        StringBuilder c=new StringBuilder();
        StringBuilder d=new StringBuilder();
        int i=0;
        int s_a=1,s_b=1,s_c=1,s_d=1;
        if(one.charAt(i)=='+')
        {
            s_a=1;
            i++;
        }    
        if(one.charAt(i)=='-')
        {
            s_a=-1;
            i++;
        }
        while(i<one.length())
        {
            if(one.charAt(i)=='+' || one.charAt(i)=='-')
                break;
            a.append(one.charAt(i));
            i++;
        }
        char a_b=one.charAt(i);
        if(one.charAt(i)=='+')
        {
            s_b=1;
            i++;
        }
        if(one.charAt(i)=='-')
        {
            s_b=-1;
            i++;
        }
        while(i<one.length())
        {
            if(one.charAt(i)=='i')
                break;
            b.append(one.charAt(i));
            i++;
        }
        i=0;
        if(two.charAt(i)=='+')
        {
            s_c=1;
            i++;
        }    
        if(two.charAt(i)=='-')
        {
            s_c=-1;
            i++;
        }
        while(i<two.length())
        {
            if(two.charAt(i)=='+' || two.charAt(i)=='-')
                break;    
            c.append(two.charAt(i));
            i++;
        }
        char c_d=two.charAt(i);
        if(two.charAt(i)=='+')
        {
            s_d=1;
            i++;
        }
        if(two.charAt(i)=='-')
        {
            s_d=-1;
            i++;
        }
        while(i<two.length())
        {
            if(two.charAt(i)=='i')
                break;
            d.append(two.charAt(i));
            i++;
        }
        int num_a=Integer.parseInt(a.toString())*s_a;
        int num_b=Integer.parseInt(b.toString())*s_b;
        int num_c=Integer.parseInt(c.toString())*s_c;
        int num_d=Integer.parseInt(d.toString())*s_d;
        StringBuilder result=new StringBuilder();
        int x=num_a*num_c-num_b*num_d;
        int y=num_a*num_d+num_b*num_c;
        result.append(x+"+"+y+"i");
        return result.toString();
    }
}
