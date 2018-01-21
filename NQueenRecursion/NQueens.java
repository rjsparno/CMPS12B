//NQueens.java
//
import java.io.*;
import java.util.*;
import java.lang.*;

class NQueens
{
	public static int Board_Size;
	public static BufferedReader in;
	public static PrintWriter out;
	public static int[] board;
	public static int solved;
	public static int[] Problem;
	public static int Counter;
	public static boolean CheckBoard(int i)
	{
		if(board[0] == -1)
		{
			//System.out.println("no Solution");
			return false;
		}
		if(board[i]>Board_Size)
		{
			return false;
		}
		for(int j=0;j<i;j++)
		{
			for(int k=j+1;k<=i;k++)
			{
				if(board[j] == board[k])
				{
					//System.out.println("False 1");
					return false;
				}
				else if(Math.abs(k-j) == Math.abs(board[k]-board[j]))
				{
					//System.out.println("False 2");
					//System.out.println("j " + j + " k " + k + " jb " + board[j] + " kb " + board[k]);
					return false;
				}
				else if(board[j] == 0 || board[k] == 0)
				{
					return false;
				}
			}
		}
		//System.out.println("True");
		return true;
	}
	public static boolean CheckAnswer()
	{
		for(int i=0;i<Problem.length;i+=2)
		{
			if(board[Problem[i]-1] != Problem[i+1])
			{
				return false;
			}
		}
		return true;
	}
	public static void PrintArrayBoard()
	{
		//System.out.print(Problem[0]+ " " + Problem[1] + " : ");

		for(int j=0;j<board.length;j++)
		{
			
			System.out.print((j+1)+" " +board[j] + " ");
			
			
		}
		System.out.println("");
	}
	public static void Iterate(int i)
	{
		while(i==board.length)
		{
		if(board[0] == -1) //exit case
		{
			return;
		}
			if(CheckAnswer())
			{
				//System.out.println("Ayy Lmao");
				System.out.print("True");
				PrintArrayBoard();
				return;
			}
			else
			{
				//System.out.println("Fuck Me lmao");
				System.out.print("False");
				PrintArrayBoard();
				board[i-1]+=1;
				Iterate(i-1);
			}
		}
		//board[i]+=1;
		if(board[0] == -1) //exit case
		{
			return;
		}
		while((!CheckBoard(i)))
		{
			board[i]+=1;
			if(board[i]>Board_Size)
			{
				if(i==0)
				{
					//System.out.println("No Solution");
					board[i] = -1; //exit case
					return;
				}
				board[i] = 0;
				board[i-1]+=1;
				Iterate(i-1);
				return;
			}
			if(board[0] == -1) //exit case
			{
				return;
			}
		}
		if(board[0] == -1) //exit case
		{
			return;
		}
		if (CheckBoard(i))
		{
		    Iterate(i+1);
		}
		return;
	}
	public static void IterateV2(int i)
	{
		if(i>=Board_Size)
		{
			Counter++;
			if(CheckAnswer())
			{
				System.out.println(Board_Size + " Board took " + Counter + " Tries");
				solved = 1;
			}
			return;
		}
		while(solved!=1)
		{
			Counter++;
			board[i]+=1;
			while(!(CheckBoard(i)))
			{
				Counter++;
				board[i]+=1;
				if(board[i]>Board_Size)
				{
					Counter++;
					//System.out.print("Returning ");
					//PrintArrayBoard();
					board[i]=0;
					return;
				}
			}
		 	if(CheckBoard(i))
			{
				//PrintArrayBoard();
			    IterateV2(i+1);
			}
		}
	}
	public static void PrintBoard()
	{
		if(board[0]== -1)
		{
			out.println("No solution");
			return;
		}
		if(board[0] == 0)
		{
			out.println("No solution");
			return;
		}
		for(int i=0;i<board.length;i++)
		{
			out.print((i+1) + " " + board[i] + " ");
		}
		out.println("");
		return;
	
	}
	public static void ParseProblem()throws IOException
	{
		int i;
		String line;
		String[] to_parse;
		String[] StringProblem;
		int RunCount = 1;
		while((line = in.readLine())!= null)
		{
			to_parse = line.trim().split(" ");
			Board_Size = Integer.parseInt(to_parse[0]);
			Problem = new int[to_parse.length-1];
			for(i=1;i<to_parse.length;i++)
			{
				Problem[i-1] = Integer.parseInt(to_parse[i]);
			}
			System.out.println("Run # "+(RunCount++));
			board = new int[Board_Size];
			//PrintBoard(Board);
			Counter = 0;
			solved = 0;
			IterateV2(0);
			System.out.println(Counter);
			PrintBoard();
		}
	}
	public static void main(String[] args)throws IOException
	{
		in = new BufferedReader(new FileReader(args[0]));
		out = new PrintWriter(new FileWriter(args[1]));
		ParseProblem();
		in.close();
		out.close();
		//Board_Size = 4;
		//int[] Board = {0,0,0,0};
		//Board = Iterate(Board,0);
		//int[] Board = new int[Board_Size];
		//CheckBoard(Board, 4);
		//int[] newBoard = {5,3,1,4,4};
		//CheckBoard(newBoard, 4);
		//Board = Iterate(Board, 0);
		//PrintBoard(Board);
	}
}
