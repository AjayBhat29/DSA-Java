/*Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.*/

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int solution[]=new int[2];
        for(int i=0;i<n;i++)
        {
            int abs_val=Math.abs(arr[i]);
            if(arr[abs_val-1]>0)
                arr[abs_val-1]*=-1;
            else
                solution[0]=abs_val;
        }
        for(int i=0;i<n;i++)
            if(arr[i]>0)
                solution[1]=i+1;
        return solution;
    }
}