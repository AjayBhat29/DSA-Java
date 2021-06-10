/* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

 
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4 */

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        List<int []> ans=new ArrayList<>();
        int []first=new int[2];
        
        first[0]=intervals[0][0];
        first[1]=intervals[0][1];
        ans.add(first);
        
        for(int i=1;i<intervals.length;i++){
            int []last=ans.get(ans.size()-1);
            int prev_start=last[0],prev_end=last[1];
            int cur_start=intervals[i][0],cur_end=intervals[i][1];
            if(prev_end>=cur_start){
                ans.remove(ans.size()-1);
                last[0]=prev_start;
                last[1]=Math.max(prev_end,cur_end);
                ans.add(last);
            }
            else{
                int []l=new int[2];
                l[0]=cur_start;
                l[1]=cur_end;
                ans.add(l);
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}
