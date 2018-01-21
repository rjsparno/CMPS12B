//TestFunction.java
import java.util.*;
import java.lang.*;
import java.io.*;
class TestFunction
{
	public static Stack<Integer> s;
	public static int stackCount;
	public static void main(String args[])
	{
		s = new Stack<Integer>();
		s.push(120);
		s.push(135);
		s.push(150);
		System.out.println(s);
		stackCount = 3;
		Integer popper = s.peek();
		System.out.println(popper);
		int[] problem = {1,120,3,150,2,135};
		CheckProblem(problem);
		//printStack();
		
	}
	public static int[] printStack()
	{
        int[] to_print = new int[stackCount];
		int j=0;
		while(!(s.empty()))
		{
			System.out.println(++j);
			to_print[stackCount-1]=s.pop();
			stackCount--;
		}
		for(int i=0;i<to_print.length;i++)
		{
			//System.out.print(to_print[i]);
		}
		reStack(to_print);
		return to_print;
	}
		public static int[] CheckProbArray()
	{
        int[] to_print = new int[stackCount+1];
		int j=0;
		while(!(s.empty()))
		{
			System.out.println(++j);
			to_print[stackCount]=s.pop();
			stackCount--;
		}
		for(int i=0;i<to_print.length;i++)
		{
			//System.out.print(to_print[i]);
		}
		reStackProbArray(to_print);
		return to_print;
	}
	public static void reStackProbArray(int[] ayylmao)
	{
		for(int i=1;i<ayylmao.length;i++)
		{
			s.push(ayylmao[i]);
			System.out.println(s);
		}
	}
	public static void reStack(int[] ayylmao)
	{
		for(int i=0;i<ayylmao.length;i++)
		{
			s.push(ayylmao[i]);
			System.out.println(s);
		}
	}
	public static boolean CheckProblem(int[] problem)
	{
		int[] to_check = CheckProbArray();
		/*int[] to_checknew = new int[to_check.length+1];
		for(int j=0;j<to_check.length;j++)
		{
			to_checknew[j+1] = to_check[j];
		}*/
		for(int i=0;i<problem.length;i+=2)
		{
			if(to_check[problem[i]] != problem[i+1])
			{
				System.out.println(problem[i] + " return false " + problem[i+1] + " kill me " + to_check[problem[i]]);
				return false;
			}
		}
		return true;
	}
}