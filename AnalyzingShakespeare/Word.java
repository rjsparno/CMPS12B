import java.io.*;
public class Word
{
	public String charWord;
	private int wordlength;
	private int frequency;
	
	//constructor()
	public Word()
	{
		this.charWord = "ayylmao";
		this.wordlength=0;
		this.frequency=0;
	}
	public Word(String CurrentWord)
	{
		this.charWord = CurrentWord;
		this.wordlength = CurrentWord.length();
		this.frequency = 1;
	}
	public String getWord()
	{
		return this.charWord;
	}
	public int getLength()
	{
		return this.wordlength;
	}
	public int getFrequency()
	{
		return this.frequency;
	}
	public void incrementFrequency()
	{
		this.frequency+=1;
	}
}
