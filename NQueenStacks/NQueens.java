//NQueens.java
import java.io.*;
import java.lang.*;
import java.util.*;
class NQueens
{
   private static int board_size;
   private static Stack<Integer> s;
   public static int stackCount;
   public static int[] to_solve;
   public static PrintWriter out;
   public static BufferedReader reader;
   public static void main(String[] args) throws IOException
   {
	   reader = new BufferedReader(new FileReader(args[0])); // open the file to reader
       out = new PrintWriter(new FileWriter(args[1])); 
	   ReadFromInputFile();
	   reader.close();
	   out.close();
	   
   }
   public static void PerformOperations(int[] query)
   {
	   s = new Stack<Integer>();
	   stackCount = 0;
	   Iterate();
	   StackArrayPrint();
	   
   }
	public static int[] StackArrayPrint()
	{
        int[] to_print = new int[stackCount];
		int j=0;
		int x=0;
		while(!(s.empty()))
		{
			j++;
			//System.out.println(j + " " +stackCount);
			x=Popping();
			//System.out.println("j "+j+" StackCount "+stackCount);
			//System.out.println("to_print.length " +to_print.length);
			to_print[stackCount] = x;//=Popping();
			//System.out.println("to_print[stackCount] = "+x);
			//stackCount--;
		}
		for(int i=0;i<to_print.length;i++)
		{
			//System.out.print(to_print[i]);
		}
		reStack(to_print);
		return to_print;
	}
	
   	public static void reStack(int[] ayylmao)
	{
		for(int i=0;i<ayylmao.length;i++)
		{
			PushThis(ayylmao[i]);
			//System.out.println(s);
		}
	}
   public static boolean checkBoard()
   {
	   int[] CheckArray;
	   CheckArray = StackArrayPrint();
	   if(CheckAttack(CheckArray))
	   {
		   return false;
	   }
	   if(stackCount==board_size)
	   {
		   
	       if(!(CheckProblem()))
	       {
		       return false;
	       }
	   }
	   //CheckAttack(CheckArray);
	   return true;
   }
	public static boolean CheckProblem()
	{
		int[] problem = to_solve;
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
				//System.out.println(problem[i] + " return false " + problem[i+1] + " kill me " + to_check[problem[i]]);
				return false;
			}
		}
		return true;
	}
			public static int[] CheckProbArray()
	{
        int[] to_print = new int[stackCount+1];
		int j=0;
		while(!(s.empty()))
		{
			//System.out.println(++j);
			to_print[stackCount]=Popping();

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
			PushThis(ayylmao[i]);
			//System.out.println(s);
		}
	}
	

   public static boolean CheckAttack(int[] CheckArray)
   {
	   for(int i=0;i<(CheckArray.length-1);i++)
	   {
		   for(int j=(i+1);j<CheckArray.length;j++)
		   {
			   if (isAttacking(CheckArray[i],i,CheckArray[j],j))
			   {
				   return true;
			   }
		   }
	   }
	   return false;
   }
   public static void printSolution()
   {
	    int[] to_print = new int[stackCount];
		int j=0;
		while(!(s.empty()))
		{
			//System.out.println(++j);
			to_print[stackCount-1]=Popping();

		}
		for(int i=0;i<to_print.length;i++)
		{
			System.out.print((i+1)+ " " + to_print[i] + " ");
			out.print((i+1)+ " " + to_print[i] + " ");
		}
		reStack(to_print);
		System.out.println("");
		out.print("\n");
		//return to_print;
   }
   public static boolean isAttacking(int x, int xindex, int y, int yindex)
   {
	   if(x == y)
	   {
		   return true;
	   }
	   else if(Math.abs(xindex-yindex)==Math.abs(x-y))
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
   }
   public static void PushThis(int x)
   {
	   //System.out.println("Pushing "+x);
	   s.push(x);
	   stackCount++;
	   //System.out.println("Stack Count: "+stackCount);
	   
   }
   public static int Popping()
   {
	   int x;
	   x = s.pop();
	   //System.out.println("Popping " + x);
	   stackCount--;
	   //System.out.println("Stack Count: " + stackCount);
	   if(s.empty())
	   {
		   //System.out.println("Empty");
	   }
	   return x;
   }
   public static void Iterate()
   {
	   int peeked;
	   int popped;
	   if(s.empty())
	   {
		   PushThis(1);
		   //s.push(1);
		   //stackCount++;
	   }
	   while(stackCount<=board_size)
	   {
		   if(checkBoard())
		   {
			   if(stackCount==board_size)
			   {
				   printSolution();
				   return;
			   }
			   PushThis(1);
			   //s.push(1);
			   //stackCount++;
		   }
		   else
		   {
			   peeked = s.peek();
			   while(peeked>=board_size) //backtrack all the way to the next part of the stack which is poppable
			   {
				   
				   popped = Popping(); // = s.pop();
				   //stackCount--;
				   if(stackCount==0)
				   {
					   out.println("No solution");
					   return;
				   }
				   peeked = s.peek();
			   }
			   popped = Popping();
			   //stackCount--
			   popped++;
			   PushThis(popped);
			   //stackCount++;
			   
		   }
	   }
   }
   public static void parseProblem(String instance)
   {
	   String[] problem = instance.split(" ");
	   board_size = Integer.parseInt(problem[0]);
	   to_solve = new int[problem.length-1];
	   for(int i=0;i<to_solve.length;i++)
	   {
		   to_solve[i]=Integer.parseInt(problem[i+1]);
	   }
	   return;
	   //return to_return;
	   
   }
   public static void ReadFromInputFile()throws IOException
   {
	   int lineCounter = 0;
	   int[] problem  = new int[2];
	   String line;
	   while((line = reader.readLine()) != null)
	   {
		   parseProblem(line);
		   PerformOperations(problem);
	   }
   }
}
