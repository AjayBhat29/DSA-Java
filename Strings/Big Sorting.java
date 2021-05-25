/* Consider an array of numeric strings where each string is a positive number with anywhere from  to  digits. 
Sort the array's elements in non-decreasing, or ascending order of their integer values and return the sorted array.

Example

Return the array ['1', '3', '150', '200'].

Function Description

Complete the bigSorting function in the editor below.

bigSorting has the following parameter(s):

string unsorted[n]: an unsorted array of integers as strings
Returns

string[n]: the array sorted in numerical order
Input Format

The first line contains an integer, , the number of strings in .
Each of the  subsequent lines contains an integer string, .

Sample Input 0
6
31415926535897932384626433832795
1
3
10
3
5
Sample Output 0
1
3
3
5
10
31415926535897932384626433832795

Sample Input 1
8
1
2
100
12303479849857341718340192371
3084193741082937
3084193741082938
111
200
Sample Output 1
1
2
100
111
200
3084193741082937
3084193741082938
12303479849857341718340192371 */

class Result {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    public static List<String> bigSorting(List<String> unsorted) {
    // Write your code here
        Collections.sort(unsorted,new StringNumberSort());
        return unsorted;
    }
    static class StringNumberSort implements Comparator<String>{
        public int compare(String a,String b){
            int na=a.length();
            int nb=b.length();
            if(na!=nb)
                return na-nb;
            int i=0,j=0;
            while(i<na && j<nb){
                int ca=a.charAt(i)-'0';
                int cb=b.charAt(j)-'0';
                if(ca==cb){
                    i++;
                    j++;
                }
                else
                    return ca-cb;
            }
            return 0;
        }
    }

}
