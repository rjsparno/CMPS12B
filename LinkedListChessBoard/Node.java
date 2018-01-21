//Node.java
class Node
{
	public ChessPiece Piece;
	public Node Next;
	public Node()
	{
	   ChessPiece Piece;
	   Next = null;
	}
	public Node(ChessPiece currPiece)
	{
		Piece = currPiece;
		Next = null;
	}
}
