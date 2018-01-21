class mergesort
{
	public static void main(String[] args)
	{
		int[] x = {3,5,2,6,9,1};
		x = sort(x);
		for(int i=0;i<x.length;i++)
		{
			System.out.println(x[i]);
		}
	}
	public static int[] sort(int[] to_sort)
	{
		int n=to_sort.length;
		if( n==1)
		{
			return to_sort;
		}
		int[] right = sort(splitright(to_sort));
		int[] left = sort(splitleft(to_sort));

		//left = sort(left);
		//right = sort(right);
		
		return merge( left, right );
	}
	public static int[] splitleft(int[] to_sort)
	{
		int length = to_sort.length;
		length = length/2;
		int[] to_return = new int[length];
		for(int i=0;i<to_return.length;i++)
		{
			System.out.println("left" + i + " " +length+ " " +to_sort.length);
			to_return[i]=to_sort[i];
		}
		PrintArray(to_return);
		return to_return;
	}
	public static int[] splitright(int[] to_sort)
	{
		int length = to_sort.length;
		int middle = length/2;

		length = (length/2+1);
		if(middle*2 < to_sort.length)
		{
			middle++;
		}
		int[] to_return = new int[middle];
		for(int i=0;i<to_return.length;i++)
		{
			System.out.println("right" + i + " " +length+ " " +to_sort.length);
			to_return[i]=to_sort[i+length-1];
		}
		PrintArray(to_return);
		return to_return;
	}
	
	
	public static int[]merge (int[] left, int[] right)
	{
		int[] to_return = new int[left.length+right.length];
		int x=0;
		int y=0;
		int z=0;
		while(x<left.length && y<right.length)
		{
			if(left[x] < right[y])
			{
				to_return[z] = left[x];
				x++;
			}
			else
			{
				to_return[z] = right[y];
				y++;
			}
			z++;
		}
		while(x<left.length)
		{
			to_return[z] = left[x];
			x++;
			z++;
		}
		while(y<right.length)
		{
			System.out.println(y + " " +left.length + " " +right.length);
			to_return[z] = right[y];
			y++;
			z++;
		}
		return to_return;
		
	}
	public static void PrintArray(int[] XD)
	{
		for(int i=0;i<XD.length;i++)
		{
			System.out.print(XD[i] + ", ");
		}
		System.out.println("");
	}

}
