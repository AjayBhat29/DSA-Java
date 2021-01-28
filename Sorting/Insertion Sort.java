static void insertionSort(int []arr)
{
	for(int i=1;i<=arr.length-1;i++)
	{
		int val=arr[counter];
		
		while(j>=0 && arr[j]>val)
		{
			arr[j+1]=arr[j];
			j--;
		}

		arr[j+1]=val;
	}
}
