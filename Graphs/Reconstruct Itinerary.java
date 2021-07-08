/* You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

Example 1:
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]

Example 2:
Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 
Constraints:
1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi and toi consist of uppercase English letters.
fromi != toi */

class Solution {
    int ticketsTotal;
    int ticketsUsed;
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String,List<String>> hmap=new HashMap<>();
        for(List<String> l:tickets){
            String src=l.get(0);
            String dst=l.get(1);
            if(!hmap.containsKey(src)){
                List<String> al=new ArrayList<>();
                al.add(dst);
                hmap.put(src,al);
            }
            else
                hmap.get(src).add(dst);
        }
        
        for(String key:hmap.keySet()){
            Collections.sort(hmap.get(key));
        }
        
        ticketsTotal=tickets.size();
        ticketsUsed=0;
        List<String> ans=new ArrayList<>();
        ans.add("JFK");
        dfs("JFK",hmap,ans);
        return ans;
    }
    void dfs(String node,HashMap<String,List<String>> hmap,List<String> ans){
        if(hmap.containsKey(node)){
            List<String> l=hmap.get(node);
            for(int i=0;i<l.size();i++){
                String nbr=l.get(i);
                l.remove(i);
                ans.add(nbr);
                ticketsUsed++;
                dfs(nbr,hmap,ans);
                
                if(ticketsUsed==ticketsTotal)
                    return;
                ticketsUsed--;
                ans.remove(ans.size()-1);
                l.add(i,nbr);
            }
        }
    }
}
