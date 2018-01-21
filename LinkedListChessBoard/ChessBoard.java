//ChessBoard.java
//
import java.io.*;
import java.util.*;
import java.lang.*;

class ChessBoard
{
	public static BufferedReader in;
	public static PrintWriter out;
	public Node Head;
	public void ChessBoard()
	{
		Head = null;
	}
	public void insert(ChessPiece CurrPiece) //works
	{
		Node Curr = new Node(CurrPiece);
		Curr.Next = Head;
		Head = Curr;
	}
	public boolean Find(int to_search_col, int to_search_row) //works
	{
		Node Curr = Head;
		while(Curr != null)
		{
			if((Curr.Piece.col==to_search_col) && (Curr.Piece.row == to_search_row))
			{
				return true;
			}
			Curr = Curr.Next;
		}
		return false;
	}
	public void PrintChessBoard() //works
	{
		Node Curr = Head;
		while(Curr != null)
		{
			System.out.println(Curr.Piece.col + " " + Curr.Piece.row);
			Curr = Curr.Next;
		}
	}
	public boolean CheckAttacking(int checkCol, int checkRow)
	{
		Node Curr = Head;
		while(Curr != null)
		{
			if((Curr.Piece.col==checkCol) && (Curr.Piece.row == checkRow))
			{
				break;
			}
			Curr = Curr.Next;
		}
		Node TheAttacked = Head;
		//System.out.println("Ayylmao");
		while(TheAttacked != null)
		{
			//System.out.println(Curr.Piece.col + " " + Curr.Piece.row);
			//System.out.println(TheAttacked.Piece.col + " " + TheAttacked.Piece.row);
			if((Curr.Piece.isAttacking(TheAttacked.Piece)))
			{
				return true;
			}
			TheAttacked = TheAttacked.Next;
		}
		return false;
	}
	public void FindLetter(int col, int row)
	{
		Node Curr = Head;
		while(Curr != null)
		{
			if((Curr.Piece.col==col) && (Curr.Piece.row == row))
			{
				break;
			}
			Curr = Curr.Next;
		}
		if(Curr != null)
		{
			out.print(Curr.Piece.letter + " ");
			return;
		}
	}
	public void doStuff(int col, int row)
	{
		//System.out.print(col + " " + row + " : ");
		if(this.Find(col,row))
		{
			this.FindLetter(col,row);
			if(this.CheckAttacking(col,row))
				{
					out.println("y");
				}
			else
				{
					out.println("n");
				}
		}
		else
		{
			out.println("-");
		}
	}
	public static void ParseProblem()throws IOException
	{
		int line_no = 0;
		String line;
		String[] parts;
		String[] toSearch;
		String[] problem;
		ChessBoard c;
		ChessPiece CurrPiece;
		char PieceLetter;
		int validity;
		while((line = in.readLine()) != null)
		{
			validity=0;
			int foo,bar;
			c = new ChessBoard();
			parts = line.split(":");
			toSearch = parts[0].split(" ");
			problem = parts[1].trim().split(" ");
			for(int i=0;i<problem.length-2;i+=3)
			{
				PieceLetter = problem[i].charAt(0);
				//System.out.println("loop");
				foo = Integer.parseInt(problem[i+1]);
				bar = Integer.parseInt(problem[i+2]);
				CurrPiece = ParsePiece(foo,bar,PieceLetter);
				if(c.Find(foo,bar))
				{
					validity = 1; //validity checker is invalid
					out.println("Invalid");
					break;
				}
				c.insert(CurrPiece);
				
			}
			if(validity==1) //if invalid go to next line
			{
				continue;
			}
			foo = Integer.parseInt(toSearch[0]);
			bar = Integer.parseInt(toSearch[1]);
			c.doStuff(foo,bar);

			line_no++;
		}
		
	}
	public static ChessPiece ParsePiece(int col, int row, char c)
	{
		ChessPiece to_return;
		if(c == 'q')
		{
			to_return = new Queen(col,row,1);
			return to_return;
		}
		else if(c == 'Q')
		{
			to_return = new Queen(col,row,0);
			return to_return;
		}
		else if(c == 'k')
		{
			to_return = new King(col,row,1);
			return to_return;
		}
		else if(c == 'K')
		{
			to_return = new King(col,row,0);
			return to_return;
		}
		else if(c == 'n')
		{
			to_return = new Knight(col,row,1);
			return to_return;
		}
		else if(c == 'N')
		{
			to_return = new Knight(col,row,0);
			return to_return;
		}
		else if(c == 'r')
		{
			to_return = new Rook(col,row,1);
			return to_return;
		}
		else if(c == 'R')
		{
			to_return = new Rook(col,row,0);
			return to_return;
		}
		else if(c == 'b')
		{
			to_return = new Bishop(col,row,1);
			return to_return;
		}
		else
		{
			to_return = new Bishop(col,row,0);
			return to_return;
		}
	}
	public static void main(String[] args)throws IOException
	{
		
		in = new BufferedReader(new FileReader(args[0]));
		out = new PrintWriter(new FileWriter(args[1]));
		ParseProblem();
		/*ChessBoard c = new ChessBoard();
		ChessPiece Ayy = new Queen(1,1,1);
		c.insert(Ayy);
		Ayy = new Queen(1,2,0);
		c.insert(Ayy);
		Ayy = new Queen(4,5,1);
		c.insert(Ayy);
		Ayy = new Queen(4,4,0);
		c.insert(Ayy);*/
		//Ayy = new Queen(1,2,1);
		//c.insert(Ayy);
		//c.PrintChessBoard();
		//c.PrintChessBoard();
		//c.doStuff(1,2);
		//c.doStuff(2,3);
		//c.doStuff(5,3);
		//c.doStuff(4,4);
		/*if(c.CheckAttacking(1,2))
		{
			System.out.println("True");
		}*/
		/*
		if(c.Find(2,1))
		{
			System.out.println("2,1");
		}
		if(c.Find(1,2))
		{
			System.out.println("1,2");
		}
		if(c.Find(3,1))
		{
			System.out.println("3,1");
		}
		*/
		in.close();
		out.close();
	}
}
