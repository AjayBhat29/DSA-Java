/* Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly. */

class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int sum=0;
        int carry=0;
        StringBuilder result=new StringBuilder();
        while(i>=0 || j>=0)
        {
            sum= (i>=0?num1.charAt(i)-48:0) + (j>=0?num2.charAt(j)-48:0);
            sum+=carry;
            carry=sum/10;
            sum=sum%10;
            result.append(sum);
            i--;
            j--;
        }
        if(carry>0)
            result.append(carry);
        return result.reverse().toString();
    }
}