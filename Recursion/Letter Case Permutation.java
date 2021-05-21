/* Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

Example 1:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:
Input: s = "3z4"
Output: ["3z4","3Z4"]

Example 3:
Input: s = "12345"
Output: ["12345"]

Example 4:
Input: s = "0"
Output: ["0"]
 
Constraints:
s will be a string with length between 1 and 12.
s will consist only of letters or digits. */

class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        getLCP(s,"",0);
        return ans;
    }
    void getLCP(String s,String o,int i){
        if(s.length()==i){
            ans.add(o);
            return;
        }
        char c=s.charAt(i);
        if((c>='A' && c<='Z')||(c>='a' && c<='z')){
            getLCP(s,o+c,i+1);
            if(Character.isUpperCase(c)){
                getLCP(s,o+Character.toLowerCase(c),i+1);
            }
            else{
                getLCP(s,o+Character.toUpperCase(c),i+1);
            }
        }
        else
            getLCP(s,o+c,i+1);
    }
}
