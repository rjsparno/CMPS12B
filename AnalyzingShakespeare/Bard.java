//-----------------------------------------------------------------------------
//Bard.java
//Ryan Sparno
//cruzid: rsparno
//email: rsparno@ucsc.edu
//HW5
//-----------------------------------------------------------------------------
import java.util.*;
import java.lang.*;
import java.io.*;
class Bard
{
	    public static Hashtable<String, Integer>Dict;
    	public static int WordCount;
		public static PrintWriter out;
		public static Scanner text;
		public static Scanner in;
		public static String[] SortedBook;
    	public static void main(String[] args) throws IOException
        {
			text = new Scanner(new File("shakespeare.txt"));
			in = new Scanner(new File(args[0]));
			out = new PrintWriter(new FileWriter(args[1]));
			Dict = new Hashtable<String, Integer>();
			WordCount=0;
			ParseText();
			//GetFrequencies();
			//int[] ayylmao = {3,5,2,4,7,4,3,5,7,9,14,10};
			//ayylmao = mergeSort(ayylmao, 0, ayylmao.length);
			//Printing(ayylmao);
			in.close();
			out.close();
		}
		public static void ParseText() throws IOException
		{
			int lineNumber = 0;
			String[] token;
			String line;
			while( text.hasNextLine() )
			{
				lineNumber++;
				line = text.nextLine().trim() + " ";
				line = ReplacePunct(line);
				
				token = line.split("\\s+");
				PutInHashTable(token);
				/*if(lineNumber<30)
				{
					System.out.println(token[0]);
				}*/
			}
			GetFrequencies();
			return;
		}
	public static String[] sort(String[] to_sort)
	{
		int n=to_sort.length;
		if( n==1)
		{
			return to_sort;
		}
		String[] right = sort(splitright(to_sort));
		String[] left = sort(splitleft(to_sort));

		//left = sort(left);
		//right = sort(right);
		
		return merge( left, right );
	}
	public static String[] splitleft(String[] to_sort)
	{
		int length = to_sort.length;
		length = length/2;
		String[] to_return = new String[length];
		for(int i=0;i<to_return.length;i++)
		{
			//System.out.println("left" + i + " " +length+ " " +to_sort.length);
			to_return[i]=to_sort[i];
		}
		PrintArray(to_return);
		return to_return;
	}
	public static String[] splitright(String[] to_sort)
	{
		int length = to_sort.length;
		int middle = length/2;

		length = (length/2+1);
		if(middle*2 < to_sort.length)
		{
			middle++;
		}
		String[] to_return = new String[middle];
		for(int i=0;i<to_return.length;i++)
		{
			//System.out.println("right" + i + " " +length+ " " +to_sort.length);
			to_return[i]=to_sort[i+length-1];
		}
		PrintArray(to_return);
		return to_return;
	}
	
	
	public static String[]merge (String[] left, String[] right)
	{
		String[] to_return = new String[left.length+right.length];
		int x=0;
		int y=0;
		int z=0;
		while(x<left.length && y<right.length)
		{
			if(GetFromHashTable(left[x]) > GetFromHashTable(right[y]))
			{
				to_return[z] = left[x];
				x++;
			}
			else if(GetFromHashTable(left[x]) == GetFromHashTable(right[y]))
			{
				if(left[x].compareTo(right[y])>=0)
				{
					to_return[z] = right[y];
					y++;
				}
				else
				{
					to_return[z] = left[x];
					x++;
				}
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
		public static String ReplacePunct(String to_parse)
		{
			to_parse = to_parse.toLowerCase();
			to_parse = to_parse.replace("."," ");
			to_parse = to_parse.replace(","," ");
			to_parse = to_parse.replace(";"," ");
			to_parse = to_parse.replace("?"," ");
			to_parse = to_parse.replace("!"," ");
			to_parse = to_parse.replace(":"," ");
			to_parse = to_parse.replace("["," ");
			to_parse = to_parse.replace("]"," ");
			return to_parse;
		}
		/*public static int[] mergeSort(int[] A,int l,int r)
		{
			int n = A.length;
			if(n==1) // base case
			{
				return A;
			}
			int middle = (l+r);
			int[] left;
			int[] right;
			left = mergeSort(A,l,m);
			right = mergeSort(A,m+1,r);
		    //int[] left = mergeSort(splitleft(A,0,n/2));
			//int[] right = mergeSort(splitright(A)));
			int[] B = merge(A,left,right);
			return B;
		}*/
		/*public static int[] merge(int[] A,int left,int middle,int right)
		{
			int[] MergeArray= new int[left.length+right.length];
			int i=0,j=0;
			while(i<left.length && j<right.length)
			{
				if(left[i]>right[j])
				{
					MergeArray[i+j] = left[i];
					i++;
				}
				else//(right[j]>left[i])
				{
					MergeArray[i+j] = right[j];
					j++;
				}
			}
			if(i<left.length)
			{
				MergeArray[i+j] = left[i];
				i++;
			}
			if(j<right.length)
			{
				MergeArray[i+j] = right[j];
				j++;
			}
			return MergeArray;
				/*else //if same frequency
				{
				}*/
			
		//}
	    public static void GetFrequencies() throws IOException
		{
		//String[] SortedArray;
		SortedBook = sort(HashToArray());
		ReadFromInputFile();
	    }
		public static void Find(int[] to_get)
		{
			int BookLength = SortedBook.length;
			int wordLengthCount=-1;
			for(int i=0;i<SortedBook.length;i++)
			{
				if(SortedBook[i].length() == to_get[0])
				{
					wordLengthCount++;
					if(wordLengthCount==to_get[1])
					{
						System.out.println("Ayy");
						System.out.println(wordLengthCount + " " + SortedBook[i] + " " + GetFromHashTable(SortedBook[i]));
                        out.println(SortedBook[i]);
						return;
					}
					
				}
				
			}
			out.println("-");
		}
		public static void PutInHashTable(String[] x)
		{
			int y;
			for(int i=0; i<x.length; i++)
			{
				//System.out.println(x[i]);
				if(Dict.containsKey(x[i]))
				{
					y = Dict.get(x[i]);
					Dict.put(x[i],(y+1));
					//System.out.println(x[i] + " lmao " +(y+1));
					continue;
				}
				WordCount++;
				Dict.put(x[i], 1);
			}
		}
		public static int GetFromHashTable(String to_get)
		{
			int XD;
			XD = Dict.get(to_get);
			return XD;
		}
		public static String[] HashToArray() //
		{
			String[] WordArray = new String[WordCount];
			int i=0;
			//System.out.println(WordCount);
			int current;
			for(String key : Dict.keySet())
			{
				current = GetFromHashTable(key);
				//System.out.println("ayy " + key + " " + current);
				WordArray[i] = key;
				i++;
			}
			return WordArray;
		}
		public static String[] SortArray(String[] WordArray)
		{
			String temp;
			for(int i=0;i<WordArray.length-1;i++)
			{
				for(int j=(i+1); j<WordArray.length;j++)
				{
					//System.out.println(GetFromHashTable(WordArray[i]) + " " + GetFromHashTable(WordArray[j]));
					if(GetFromHashTable(WordArray[i]) < GetFromHashTable(WordArray[j]))
					{
						//System.out.println(WordArray[i] + " " + WordArray[j]);
						temp=WordArray[i];
						WordArray[i] = WordArray[j];
						WordArray[j] = temp;
					}
					else if(GetFromHashTable(WordArray[i]) == GetFromHashTable(WordArray[j]))
					{
						//System.out.println("XD");
						if(WordArray[i].compareTo(WordArray[j])>=0)
						{
						//System.out.println(WordArray[i] + " vs. " + (WordArray[j]));
						temp=WordArray[i];
						WordArray[i] = WordArray[j];
						WordArray[j] = temp;
						}
					}
				}
			}
			return WordArray;
		}
		public static void Printing(int[] to_print)
		{
			for(int i=0; i<to_print.length; i++)
			{
				//System.out.println(to_print[i]);
			}
		}
		public static void PrintArray(String[] to_print)
		{
			for(int i=0; i<to_print.length; i++)
			{
				//System.out.println(to_print[i] + " " + GetFromHashTable(to_print[i]));
			}
		}
	   public static void parseProblem(String instance)
	   {
		   String[] problem = instance.split(" ");
		   int[] converted = new int[2];
		   converted[0] = Integer.parseInt(problem[0]);
		   converted[1] = Integer.parseInt(problem[1]);
		   Find(converted);
		   return;
		   //return to_return;
		   
	   }
	   public static void ReadFromInputFile()throws IOException
	   {
		   int lineCounter = 0;
		   int[] problem  = new int[2];
		   String line;
		   while(in.hasNextLine())
		   {
			   lineCounter++;
			   line = in.nextLine().trim() + " ";
			   parseProblem(line);
		   }
	   }
}
