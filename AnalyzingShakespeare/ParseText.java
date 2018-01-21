import java.io.*;
import java.lang.*;
import java.util.*;
class ParseText
{
	//public static BufferedReader text;
	public static void main(String[] args)
	{
		//text = BufferedReader(new FileReader("shakespeare.txt"));
		Parsetext();
	}
	public static void Parsetext()
	{
		String text = "ayy lmao.boi,hey;kill!me?now:";
		
		text = ReplacePunct(text);
		//newString = text.split("[.,!?:;]+\\s*");
		System.out.println(text);
	}
	public static String ReplacePunct(String to_parse)
	{
		to_parse = to_parse.replace("."," ");
		to_parse = to_parse.replace(","," ");
		to_parse = to_parse.replace(";"," ");
		to_parse = to_parse.replace("?"," ");
		to_parse = to_parse.replace("!"," ");
		to_parse = to_parse.replace(":"," ");
		return to_parse;
	}
}
