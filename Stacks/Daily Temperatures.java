/* Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. */

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n=T.length;
        int a[]=NGR(T,n);
        for(int i=0;i<n;i++)
            a[i]=Math.abs(i-a[i]);
        return a;
    }
  
    int[] NGR(int T[],int n)//Nearest Greater to Right
    {
        int a[]=new int[n];
        Stack<Pair> stack=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            if(stack.empty())
                a[i]=i;
            else if(!stack.empty() && stack.peek().temp>T[i])
                a[i]=stack.peek().index;
            else if(!stack.empty() && stack.peek().temp<=T[i])
            {
                while(!stack.empty() && stack.peek().temp<=T[i])
                    stack.pop();
                if(stack.empty())
                    a[i]=i;
                else
                    a[i]=stack.peek().index;
            }
            stack.push(new Pair(T[i],i));
        }
        return a;
    }
}

class Pair
{
    int temp;
    int index;
    
    public Pair(int temp,int index)
    {
        this.temp=temp;
        this.index=index;
    }
}
