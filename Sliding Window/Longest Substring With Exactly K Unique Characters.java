/* 1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".

Input Format
A string

Output Format
A number representing length of the longest K unique characters substring. 

Constraints
1 <= length of string <= 10^5
1 <= k <= 26

Sample Input
aabcbcdbca
2

Sample Output
4 */

	public static int solution(String s, int k){
		// write your code here
		int max=-1;
        Map<Character,Integer> hmap=new HashMap<>();
        int i=0,j=0;
        int n=s.length();
        
        while(j<n)
        {
            hmap.put(s.charAt(j),hmap.getOrDefault(s.charAt(j),0)+1);
            if(hmap.size()<k)
                j++;
            else if(hmap.size()==k)
            {
                max=Math.max(max,j-i+1);
                j++;
            }
            else
            {
                while(hmap.size()>k)
                {
                    char ch=s.charAt(i);
                    int freq=hmap.get(ch);
                    freq--;
                    if(freq==0)
                        hmap.remove(ch);
                    else
                        hmap.put(ch,freq);
                    i++;
                }
                j++;
            }
        }
        return max;
	}

