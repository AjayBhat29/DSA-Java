/* Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hmap=new HashMap<>();
        for(String str: strs)
        {
            char a[]=str.toCharArray();
            Arrays.sort(a);
            String temp=new String(a);
            if(!hmap.containsKey(temp))
            {
                List<String> l=new ArrayList<>();
                l.add(str);
                hmap.put(temp,l);
            }
            else
            {
                hmap.get(temp).add(str);
            }
        }
        List<List<String>> answer=new ArrayList<List<String>>();
        for(List<String> l: hmap.values())
        {
            answer.add(l);
        }
        return answer;
    }
}